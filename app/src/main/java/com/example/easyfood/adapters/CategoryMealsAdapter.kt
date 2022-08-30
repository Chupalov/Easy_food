package com.example.easyfood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.databinding.ActivityCategoryMealsBinding
import com.example.easyfood.databinding.MealItemBinding
import com.example.easyfood.pojo.MealList
import com.example.easyfood.pojo.MealsByCategory
import com.example.easyfood.viewModel.CategoryMealsViewModel

class CategoryMealsAdapter: RecyclerView.Adapter<CategoryMealsAdapter.CategoryMealsViewMoldel> (){

    private var mealList = ArrayList<MealsByCategory>()

    fun setMealsList(mealList: List<MealsByCategory>){
        this.mealList = mealList as ArrayList<MealsByCategory> /* = java.util.ArrayList<com.example.easyfood.pojo.MealsByCategory> */
        notifyDataSetChanged()
    }

    inner class CategoryMealsViewMoldel(val binding: MealItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealsViewMoldel {
        return CategoryMealsViewMoldel(
            MealItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryMealsViewMoldel, position: Int) {
        Glide.with(holder.itemView).load(mealList[position].strMealThumb).into(holder.binding.imgMeal)
        holder.binding.tvMealName.text = mealList[position].strMeal
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}