package com.example.superapp.TextEditor

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Format_italic: ImageVector
    get() {
        if (_Format_italic != null) return _Format_italic!!

        _Format_italic = ImageVector.Builder(
            name = "Format_italic",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(200f, 760f)
                verticalLineToRelative(-100f)
                horizontalLineToRelative(160f)
                lineToRelative(120f, -360f)
                horizontalLineTo(320f)
                verticalLineToRelative(-100f)
                horizontalLineToRelative(400f)
                verticalLineToRelative(100f)
                horizontalLineTo(580f)
                lineTo(460f, 660f)
                horizontalLineToRelative(140f)
                verticalLineToRelative(100f)
                close()
            }
        }.build()

        return _Format_italic!!
    }

private var _Format_italic: ImageVector? = null

val Format_bold: ImageVector
    get() {
        if (_Format_bold != null) return _Format_bold!!

        _Format_bold = ImageVector.Builder(
            name = "Format_bold",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(272f, 760f)
                verticalLineToRelative(-560f)
                horizontalLineToRelative(221f)
                quadToRelative(65f, 0f, 120f, 40f)
                reflectiveQuadToRelative(55f, 111f)
                quadToRelative(0f, 51f, -23f, 78.5f)
                reflectiveQuadTo(602f, 469f)
                quadToRelative(25f, 11f, 55.5f, 41f)
                reflectiveQuadToRelative(30.5f, 90f)
                quadToRelative(0f, 89f, -65f, 124.5f)
                reflectiveQuadTo(501f, 760f)
                close()
                moveToRelative(121f, -112f)
                horizontalLineToRelative(104f)
                quadToRelative(48f, 0f, 58.5f, -24.5f)
                reflectiveQuadTo(566f, 588f)
                reflectiveQuadToRelative(-10.5f, -35.5f)
                reflectiveQuadTo(494f, 528f)
                horizontalLineTo(393f)
                close()
                moveToRelative(0f, -228f)
                horizontalLineToRelative(93f)
                quadToRelative(33f, 0f, 48f, -17f)
                reflectiveQuadToRelative(15f, -38f)
                quadToRelative(0f, -24f, -17f, -39f)
                reflectiveQuadToRelative(-44f, -15f)
                horizontalLineToRelative(-95f)
                close()
            }
        }.build()

        return _Format_bold!!
    }

private var _Format_bold: ImageVector? = null

val Format_underlined: ImageVector
    get() {
        if (_Format_underlined != null) return _Format_underlined!!

        _Format_underlined = ImageVector.Builder(
            name = "Format_underlined",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(200f, 840f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(560f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(280f, -160f)
                quadToRelative(-101f, 0f, -157f, -63f)
                reflectiveQuadToRelative(-56f, -167f)
                verticalLineToRelative(-330f)
                horizontalLineToRelative(103f)
                verticalLineToRelative(336f)
                quadToRelative(0f, 56f, 28f, 91f)
                reflectiveQuadToRelative(82f, 35f)
                reflectiveQuadToRelative(82f, -35f)
                reflectiveQuadToRelative(28f, -91f)
                verticalLineToRelative(-336f)
                horizontalLineToRelative(103f)
                verticalLineToRelative(330f)
                quadToRelative(0f, 104f, -56f, 167f)
                reflectiveQuadToRelative(-157f, 63f)
            }
        }.build()

        return _Format_underlined!!
    }

private var _Format_underlined: ImageVector? = null

