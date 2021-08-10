package com.example.talkademy_phase4.phase7.dataClass

import com.example.talkademy_phase4.phase7.enumerian.Continent

class DataFakeGenerator {
    companion object {

        public fun getAmericaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country("America", Continent.AMERICA, arrayListOf())
            val country2 = Country("Canada", Continent.AMERICA, arrayListOf())
            val country3 = Country("Brazil", Continent.AMERICA, arrayListOf())
            val country4 = Country("Argentina", Continent.AMERICA, arrayListOf())

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        public fun getAfricaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country("South Africa", Continent.AFRICA, arrayListOf())
            val country2 = Country("Egypt", Continent.AFRICA, arrayListOf())
            val country3 = Country("Morocco", Continent.AFRICA, arrayListOf())
            val country4 = Country("Ethiopia", Continent.AFRICA, arrayListOf())

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        public fun getAsiaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country("Iran", Continent.ASIA, arrayListOf())
            val country2 = Country("China", Continent.ASIA, arrayListOf())
            val country3 = Country("South Korea", Continent.ASIA, arrayListOf())
            val country4 = Country("Japan", Continent.ASIA, arrayListOf())

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        public fun getEuropeCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country("Germany", Continent.EUROPE, arrayListOf())
            val country2 = Country("Italy", Continent.EUROPE, arrayListOf())
            val country3 = Country("France", Continent.EUROPE, arrayListOf())
            val country4 = Country("United Kingdom", Continent.EUROPE, arrayListOf())

            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)

            return countriesList
        }

        public fun getAustraliaCountry(): List<Country> {
            val countriesList = arrayListOf<Country>()

            val country1 = Country("Australia", Continent.AUSTRALIA, arrayListOf())
            val country2 = Country("New Zealand", Continent.AUSTRALIA, arrayListOf())

            countriesList.add(country1)
            countriesList.add(country2)

            return countriesList
        }
    }

}