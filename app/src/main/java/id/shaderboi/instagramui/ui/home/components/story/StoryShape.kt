package id.shaderboi.instagramui.ui.home.components.story

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

data class IndicatorPlacement(
    val width: Dp,
    val height: Dp,
    val x: Float,
    val y: Float,
)

class CircleWithIndicatorButton(
    private val cutoutShape: Shape,
    private val indicatorPlacement: IndicatorPlacement
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val boundingRectangle = Path().apply {
            addOval(Rect(0F, 0F, size.width, size.height))
        }
        val path = Path().apply {
            addCutoutShape(size, layoutDirection, density)
            // Subtract this path from the bounding rectangle
            op(boundingRectangle, this, PathOperation.Difference)
        }
        return Outline.Generic(path)
    }

    private fun Path.addCutoutShape(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) {
        val cutoutOffset = with(density) { 2.dp.toPx() }
        val indicatorPlacementWidth = with(density) { indicatorPlacement.width.toPx() }
        val indicatorPlacementHeight = with(density) { indicatorPlacement.height.toPx() }

        val cutoutSize = Size(
            width = indicatorPlacementWidth + (cutoutOffset * 2),
            height = indicatorPlacementHeight + (cutoutOffset * 2)
        )

        val cutoutStartX = indicatorPlacement.x * size.width - cutoutOffset
        val cutoutStartY = indicatorPlacement.y * size.height - cutoutOffset

        addOutline(cutoutShape.createOutline(cutoutSize, layoutDirection, density))
        translate(Offset(cutoutStartX, cutoutStartY))
    }
}