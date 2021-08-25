package com.example.talkademy_phase4.phase9

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talkademy_phase4.databinding.FragmentContactListBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList


private const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
private const val REQUEST_CONTACT = 12

class ContactListFragment : Fragment() {

    private var _binding: FragmentContactListBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var dao: ContactsDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactsDatabase = ContactsDataBase
        dao = contactsDatabase.getDatabase(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getContactsBtn.setOnClickListener {
            if (checkPermission()) {
                getContacts()
                binding.progressBar.visibility = View.VISIBLE
            } else
                requestPermission()
        }

        binding.chooseContactsBtn.apply {
            val pickContactIntent =
                Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)

            setOnClickListener {
                if (checkPermission())
                    startActivityForResult(pickContactIntent, REQUEST_CONTACT)
                else
                    requestPermission()
            }
        }
    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        requestPermissions(
            requireActivity(), arrayOf(Manifest.permission.READ_CONTACTS),
            PERMISSIONS_REQUEST_READ_CONTACTS
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_READ_CONTACTS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Util.showToast(requireContext(), "Permission Granted")
                    getContacts()
                } else {
                    Util.showToast(requireContext(), "Permission Denied")
                }
                return
            }
        }
    }


    private fun getContacts() {

        val contactsInfoList = getSelectedContactInfo(ContactsContract.Contacts.CONTENT_URI)

        println(contactsInfoList.toString())

        insertDataToRoom(contactsInfoList)

        Handler(Looper.getMainLooper()).postDelayed({
            initRecycler()
        }, 100)
    }

    private fun insertDataToRoom(infoList: List<ContactsInfo>?) {
        infoList ?: return


        GlobalScope.launch {
            infoList.forEach {
                dao.contactDao().insert(it)
            }
        }
    }

    private fun initRecycler() {

        val list = arrayListOf<ContactsInfo>()

        GlobalScope.launch {
            list.addAll(dao.contactDao().getAllContacts())
        }

        val contactAdapter = ContactsAdapter(list, this)
        binding.contactsRecyclerView.apply {
            adapter = contactAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        if (binding.progressBar.visibility == View.VISIBLE)
            binding.progressBar.visibility = View.INVISIBLE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (REQUEST_CONTACT == requestCode && data != null) {

                val contactUri: Uri = data.data ?: Uri.EMPTY
                Util.launchItemFragment(this, getSelectedContactInfo(contactUri)[0], "item")

            }
        }
    }

    private fun getSelectedContactInfo(contactUri: Uri): List<ContactsInfo> {
        val contactsInfoList = ArrayList<ContactsInfo>()
        var contactsInfo: ContactsInfo? = null

        val cursor: Cursor? = requireActivity().contentResolver.query(
            contactUri,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        if (cursor != null) {
            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val hasPhoneNumber =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                            .toInt()
                    if (hasPhoneNumber > 0) {

                        val contactId =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                        val displayName =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        val contactImage =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI))
                        val phoneCursor: Cursor? = requireActivity().contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(contactId),
                            null
                        )
                        if (phoneCursor != null) {
                            if (phoneCursor.moveToNext()) {
                                val phoneNumber = phoneCursor.getString(
                                    phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                                )
                                if (contactId.isNotEmpty() && displayName.isNotEmpty() && phoneNumber.isNotEmpty()) {
                                    contactsInfo = ContactsInfo(
                                        contactId,
                                        displayName,
                                        phoneNumber,
                                        contactImage
                                    )
                                }
                            }
                        }
                        phoneCursor?.close()
                        if (contactsInfo != null) contactsInfoList.add(contactsInfo)
                    }
                }
            }
        }
        cursor?.close()
        return contactsInfoList
    }

    override fun onResume() {
        super.onResume()
        initRecycler()
    }

}