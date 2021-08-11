package com.example.talkademy_phase4.phase7.dataClass

import com.example.talkademy_phase4.phase7.enumerian.Continent

class DataFakeGenerator {
    companion object {

        fun getAmericaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country(
                "America",
                Continent.AMERICA,
                arrayListOf(
                    CountrySite("America test1"),
                    CountrySite("America test2"),
                    CountrySite("America test3")
                )
            )
            val country2 = Country(
                "Canada", Continent.AMERICA, arrayListOf(
                    CountrySite("Canada test1"),
                    CountrySite("Canada test2"),
                    CountrySite("Canada test3")
                )
            )
            val country3 = Country(
                "Brazil", Continent.AMERICA, arrayListOf(
                    CountrySite("Brazil test1"),
                    CountrySite("Brazil test2"),
                    CountrySite("Brazil test3")
                )
            )
            val country4 = Country(
                "Argentina", Continent.AMERICA, arrayListOf(
                    CountrySite("Argentina test1"),
                    CountrySite("Argentina test2"),
                    CountrySite("Argentina test3")
                )
            )

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        fun getAfricaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country(
                "South Africa", Continent.AFRICA, arrayListOf(
                    CountrySite("South Africa test1"),
                    CountrySite("South Africa test2"),
                    CountrySite("South Africa test3")
                )
            )
            val country2 = Country(
                "Egypt", Continent.AFRICA, arrayListOf(
                    CountrySite("Egypt test1"),
                    CountrySite("Egypt test2"),
                    CountrySite("Egypt test3")
                )
            )
            val country3 = Country(
                "Morocco", Continent.AFRICA, arrayListOf(
                    CountrySite("Morocco test1"),
                    CountrySite("Morocco test2"),
                    CountrySite("Morocco test3")
                )
            )
            val country4 = Country(
                "Ethiopia", Continent.AFRICA, arrayListOf(
                    CountrySite("Ethiopia test1"),
                    CountrySite("Ethiopia test2"),
                    CountrySite("Ethiopia test3")
                )
            )

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        fun getAsiaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country(
                "Iran", Continent.ASIA, arrayListOf(
                    CountrySite("Iran test1"),
                    CountrySite("Iran test2"),
                    CountrySite("Iran test3")
                )
            )
            val country2 = Country(
                "China", Continent.ASIA, arrayListOf(
                    CountrySite("China test1"),
                    CountrySite("China test2"),
                    CountrySite("China test3")
                )
            )
            val country3 = Country(
                "South Korea", Continent.ASIA, arrayListOf(
                    CountrySite("South Korea test1"),
                    CountrySite("South Korea test2"),
                    CountrySite("South Korea test3")
                )
            )
            val country4 = Country(
                "Japan", Continent.ASIA, arrayListOf(
                    CountrySite("Japan test1"),
                    CountrySite("Japan test2"),
                    CountrySite("Japan test3")
                )
            )

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        fun getEuropeCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country(
                "Germany", Continent.EUROPE, arrayListOf(
                    CountrySite("Germany test1"),
                    CountrySite("Germany test2"),
                    CountrySite("Germany test3")
                )
            )
            val country2 = Country(
                "Italy", Continent.EUROPE, arrayListOf(
                    CountrySite("Italy test1"),
                    CountrySite("Italy test2"),
                    CountrySite("Italy test3")
                )
            )
            val country3 = Country(
                "France", Continent.EUROPE, arrayListOf(
                    CountrySite("France test1"),
                    CountrySite("France test2"),
                    CountrySite("France test3")
                )
            )
            val country4 = Country(
                "United Kingdom", Continent.EUROPE, arrayListOf(
                    CountrySite("United Kingdom test1"),
                    CountrySite("United Kingdom test2"),
                    CountrySite("United Kingdom test3")
                )
            )

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        fun getAustraliaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country(
                "Australia", Continent.AUSTRALIA, arrayListOf(
                    CountrySite("Australia test1"),
                    CountrySite("Australia test2"),
                    CountrySite("Australia test3")
                )
            )
            val country2 = Country(
                "NewZealand", Continent.AUSTRALIA, arrayListOf(
                    CountrySite("New Zealand test1"),
                    CountrySite("New Zealand test2"),
                    CountrySite("New Zealand test3")
                )
            )

            countriesList.add(country1)
            countriesList.add(country2)

            return countriesList
        }
    }

}