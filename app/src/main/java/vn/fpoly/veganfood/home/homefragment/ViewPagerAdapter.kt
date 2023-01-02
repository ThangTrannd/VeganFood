package vn.fpoly.veganfood.home.homefragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import vn.fpoly.veganfood.home.homefragment.productfragment.ListProductFragment
import vn.fpoly.veganfood.model.CategoriesResult

internal class ViewPagerAdapter(
  fragment: Fragment,
  private val list: List<CategoriesResult.CategoriesResultModel>
) : FragmentStateAdapter(
  fragment.childFragmentManager,
  fragment.viewLifecycleOwner.lifecycle
) {
  override fun getItemCount(): Int = list.size

  override fun createFragment(position: Int): Fragment = ListProductFragment.newInstance(list[position].id.toString())

}
