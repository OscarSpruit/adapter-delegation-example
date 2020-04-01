package com.example.adapterdelegation

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Gist from: https://gist.github.com/mohsenoid/8ffdfa53f0465533833b0b44257aa641
 *
 * DividerItemDecorationNoLast is a [RecyclerView.ItemDecoration] that can be used as a divider
 * between items of a [LinearLayoutManager]. It supports both [.HORIZONTAL] and
 * [.VERTICAL] orientations.
 *
 * <pre>
 * mDividerItemDecorationNoLast = new DividerItemDecorationNoLast(recyclerView.getContext(),
 * mLayoutManager.getOrientation());
 * recyclerView.addItemDecoration(mDividerItemDecorationNoLast);
</pre> *
 */
class SpaceItemDecoration(private val context: Context, orientation: Int) : RecyclerView.ItemDecoration() {

    /**
     * Current orientation. Either [.HORIZONTAL] or [.VERTICAL].
     */
    private var mOrientation: Int = 0

    private var mSizeInPixels: Int = 0

    init {
        setOrientation(orientation)
        setSpace(8)
    }

    /**
     * Sets the orientation for this divider. This should be called if
     * [RecyclerView.LayoutManager] changes orientation.
     *
     * @param orientation [.HORIZONTAL] or [.VERTICAL]
     */
    fun setOrientation(orientation: Int) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw IllegalArgumentException(
                "Invalid orientation. It should be either HORIZONTAL or VERTICAL"
            )
        }
        mOrientation = orientation
    }

    fun setSpace(dp: Int) {
        mSizeInPixels = TypedValue.applyDimension(COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == parent.adapter?.itemCount?.let { it - 1 }) {
            outRect.setEmpty()
        } else {
            if (mOrientation == VERTICAL) {
                outRect.set(0, 0, 0, mSizeInPixels)
            } else {
                outRect.set(0, 0, mSizeInPixels, 0)
            }
        }
    }

    companion object {
        const val HORIZONTAL = LinearLayout.HORIZONTAL
        const val VERTICAL = LinearLayout.VERTICAL
    }
}
