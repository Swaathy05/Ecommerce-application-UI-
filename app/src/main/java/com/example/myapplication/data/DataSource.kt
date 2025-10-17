package com.example.myapplication.data

import com.example.myapplication.R
object  DataSource {
   fun loadCategories(): List<Categories> {
      return listOf<Categories>(
           Categories(stringResourceId = R.string.Fresh_Produce,
           imageResourceId = R.drawable.freshproduce),
          Categories(stringResourceId = R.string.Bakery_items,
              imageResourceId = R.drawable.bakeryitems),
          Categories(stringResourceId = R.string.Diary_Products,
              imageResourceId = R.drawable.diaryproductsfinalimg),
          Categories(stringResourceId = R.string.Packaged_Foods,
              imageResourceId = R.drawable.layskurkurefinal),
          Categories(stringResourceId = R.string.Snacks_and_Beverages,
              imageResourceId = R.drawable.snacksandbeverages),
          Categories(stringResourceId = R.string.Stationery,
              imageResourceId = R.drawable.stationeries),
          Categories(stringResourceId = R.string.Pet_Food,
              imageResourceId = R.drawable.petfood),
          Categories(stringResourceId = R.string.Personal_Care,
              imageResourceId = R.drawable.personalcare),
          Categories(stringResourceId = R.string.Household_Essentials,
              imageResourceId = R.drawable.household),
          Categories(stringResourceId = R.string.Smoothies,
              imageResourceId = R.drawable.smoothies),

       )
   }
    fun loadfreshproduceitem(category: String): List<Item> {
        return when (category) {
                "Fresh Produces" -> listOf(
           Item(R.string.Bananas,R.string.Fresh_Produce,"1kg",70,R.drawable.banana) ,
           Item(R.string.Apples,R.string.Fresh_Produce,"1kg",100,R.drawable.apple),
           Item(R.string.Grapes,R.string.Fresh_Produce,"1kg",60,R.drawable.grapes),
           Item(R.string.Mangoes,R.string.Fresh_Produce,"1kg",70,R.drawable.mangoes),
           Item(R.string.Oranges,R.string.Fresh_Produce,"1kg",60,R.drawable.oranges),
           Item(R.string.Carrot,R.string.Fresh_Produce,"1kg",50,R.drawable.carrot),
           Item(R.string.Onion,R.string.Fresh_Produce,"1kg",120,R.drawable.onion),
           Item(R.string.Tomato,R.string.Fresh_Produce,"1kg",130,R.drawable.tomato),
           Item(R.string.Spinach,R.string.Fresh_Produce,"1kg",120,R.drawable.spinach),
           Item(R.string.Potato,R.string.Fresh_Produce,"1kg",100,R.drawable.potato),

       )
            "Bakery Items" -> listOf(
                Item(R.string.Bread, R.string.Bakery_items, "500g", 50, R.drawable.bread),
              // Item(R.string.Croissant, R.string.Bakery_items, "2pcs", 40, R.drawable.croissant),
                Item(R.string.Muffins, R.string.Bakery_items, "1pc", 30, R.drawable.muffin),
                Item(R.string.Cakes, R.string.Bakery_items, "500g", 300, R.drawable.cake),
                Item(R.string.Pastry, R.string.Bakery_items, "1pc", 80, R.drawable.pastry)
            )
            "Diary Products" -> listOf(
                Item(R.string.Milk, R.string.Diary_Products, "1L", 60, R.drawable.milk),
                Item(R.string.Cheese, R.string.Diary_Products, "200g", 150, R.drawable.cheese),
                Item(R.string.Butter, R.string.Diary_Products, "500g", 250, R.drawable.butter),
                Item(R.string.Yogurt, R.string.Diary_Products, "500g", 90, R.drawable.yogurt),
                Item(R.string.Cream, R.string.Diary_Products, "200g", 100, R.drawable.cream)
            )
            "Packaged Foods" -> listOf(
                Item(R.string.Chips, R.string.Packaged_Foods, "1 pack", 50, R.drawable.chips),
                Item(R.string.Cookies, R.string.Packaged_Foods, "200g", 70, R.drawable.cookies),
                Item(R.string.Noodles, R.string.Packaged_Foods, "1 pack", 30, R.drawable.noodles),
                Item(R.string.Cereal, R.string.Packaged_Foods, "500g", 250, R.drawable.cereal),
                Item(R.string.Candies, R.string.Packaged_Foods, "1 pack", 40, R.drawable.candy)
            )
            "Snacks and Beverages" -> listOf(
                Item(R.string.Soda, R.string.Snacks_and_Beverages, "500ml", 40, R.drawable.cola),
                Item(R.string.Chips, R.string.Snacks_and_Beverages, "1 pack", 50, R.drawable.chips),
                Item(R.string.Juice, R.string.Snacks_and_Beverages, "1L", 90, R.drawable.juice),
                Item(R.string.Cookies, R.string.Snacks_and_Beverages, "200g", 70, R.drawable.cookies),
                Item(R.string.Nuts, R.string.Snacks_and_Beverages, "100g", 120, R.drawable.nuts)
            )
            "Stationery" -> listOf(
                Item(R.string.Notebook, R.string.Stationery, "1pc", 50, R.drawable.notebook),
                Item(R.string.Pen, R.string.Stationery, "10pcs", 100, R.drawable.pens),
                Item(R.string.Eraser, R.string.Stationery, "1pc", 10, R.drawable.erasers),
                Item(R.string.Pencil, R.string.Stationery, "12pcs", 80, R.drawable.pencils),
                Item(R.string.Marker, R.string.Stationery, "1pc", 30, R.drawable.marker)
            )
            "Pet Foods" -> listOf(
                Item(R.string.Dog_Food, R.string.Pet_Food, "1kg", 300, R.drawable.dog_food),
                Item(R.string.Cat_Food, R.string.Pet_Food, "1kg", 350, R.drawable.cat_food),
                Item(R.string.Bird_Seeds, R.string.Pet_Food, "500g", 120, R.drawable.bird_seed),
                Item(R.string.Fish_Food, R.string.Pet_Food, "200g", 100, R.drawable.fish_food),
                Item(R.string.Treats, R.string.Pet_Food, "1 pack", 150, R.drawable.treats)
            )
            "Personal Care" -> listOf(
                Item(R.string.Shampoo, R.string.Personal_Care, "500ml", 200, R.drawable.shampoo),
                Item(R.string.Soap, R.string.Personal_Care, "100g", 40, R.drawable.soap),
                Item(R.string.Toothpaste, R.string.Personal_Care, "150g", 90, R.drawable.toothpaste),
                Item(R.string.Deodorant, R.string.Personal_Care, "100ml", 150, R.drawable.face_wash),
                Item(R.string.Lotion, R.string.Personal_Care, "200ml", 250, R.drawable.lotion)
            )
            "Household Essentials" -> listOf(
                Item(R.string.Detergent, R.string.Household_Essentials, "1kg", 150, R.drawable.detergents),
                Item(R.string.Tissue_papers, R.string.Household_Essentials, "12 rolls", 300, R.drawable.toilet_paper),
                Item(R.string.Cleaners, R.string.Household_Essentials, "1L", 200, R.drawable.cleaner),
                Item(R.string.Sponges, R.string.Household_Essentials, "5pcs", 50, R.drawable.sponges),
                Item(R.string.Dustbin, R.string.Household_Essentials, "1pc", 500, R.drawable.dustbin)
            )
            "Smoothies" -> listOf(
                Item(R.string.Berry_Smoothie, R.string.Smoothies, "250ml", 150, R.drawable.strawberry_smoothie),
                Item(R.string.Green_Smoothie, R.string.Smoothies, "250ml", 120, R.drawable.banana_smoothie),
                Item(R.string.Mango_Smoothie, R.string.Smoothies, "250ml", 130, R.drawable.mango_smoothie),
                Item(R.string.Protein_Smoothie, R.string.Smoothies, "250ml", 160, R.drawable.blueberry_smoothie),
                Item(R.string.Tropical_Smoothie, R.string.Smoothies, "250ml", 180, R.drawable.mixed_berry_smoothie)
            )
            else -> emptyList()
        }
    }
}


