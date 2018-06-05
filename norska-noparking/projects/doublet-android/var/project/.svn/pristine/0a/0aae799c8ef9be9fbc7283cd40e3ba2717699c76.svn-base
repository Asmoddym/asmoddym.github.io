package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon

import android.util.Log
import net.noparking.projects.utl.Position
import net.noparking.projects.view.ImageEditionView.canvas.modes.PolygonsDrawingMode

class PolygonRedimensionData(polygons: MutableList<Polygon>, polygon_id: Int, side_id: Int, is_from: Boolean) {
    private val _polygons = polygons
    private val _polygon_id = polygon_id
    private val _side_id = side_id
    private val _is_from = is_from
    var closing_proposition = false

    fun updatePolygon(x: Float, y: Float) {
        if (_is_from) {
            redimensionFrom(x, y)
        } else {
            redimensionTo(x, y)
        }
        _polygons[_polygon_id].sides[_side_id].update()
        if (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING_CLOSED) {
            _polygons[_polygon_id].updateGlobalPath()
        }
    }

    fun resetStatus() {
        if (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING_CLOSED) {
            _polygons[_polygon_id].status = Polygon.CLOSED
        } else {
            _polygons[_polygon_id].status = Polygon.IN_PROGRESS
        }
    }

    fun redimensionTo(x: Float, y: Float) {
        if (_side_id == _polygons[_polygon_id].sides.size - 1 &&
                _polygons[_polygon_id].getOriginPosition().isCloseFrom(Position(x, y), PolygonsDrawingMode.TOLERANCE)) {
            _polygons[_polygon_id].sides[_side_id].to.x = _polygons[_polygon_id].getOriginPosition().x
            _polygons[_polygon_id].sides[_side_id].to.y = _polygons[_polygon_id].getOriginPosition().y
            closing_proposition = true
        } else {
            _polygons[_polygon_id].sides[_side_id].to.x = x
            _polygons[_polygon_id].sides[_side_id].to.y = y
            closing_proposition = false
        }

        if (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING_CLOSED ||
                (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING && _side_id != _polygons[_polygon_id].sides.size - 1)) {
            val next_side_id = when (_side_id) {
                _polygons[_polygon_id].sides.size - 1 -> 0
                else -> _side_id + 1
            }
            _polygons[_polygon_id].sides[next_side_id].from.x = x
            _polygons[_polygon_id].sides[next_side_id].from.y = y
            _polygons[_polygon_id].sides[next_side_id].update()
        }
    }

    fun redimensionFrom(x: Float, y: Float) {
        if (_side_id == 0 &&
                _polygons[_polygon_id].getLastSide().to.isCloseFrom(Position(x, y), PolygonsDrawingMode.TOLERANCE)) {
            _polygons[_polygon_id].sides[0].from.x = _polygons[_polygon_id].getLastSide().to.x
            _polygons[_polygon_id].sides[0].from.y = _polygons[_polygon_id].getLastSide().to.y
            closing_proposition = true
        } else {
            _polygons[_polygon_id].sides[_side_id].from.x = x
            _polygons[_polygon_id].sides[_side_id].from.y = y
        }

        if (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING_CLOSED ||
                (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING && _side_id != 0)) {
            val previous_side_id = when (_side_id) {
                0 -> _polygons[_polygon_id].sides.size - 1
                else -> _side_id - 1
            }
            _polygons[_polygon_id].sides[previous_side_id].to.x = x
            _polygons[_polygon_id].sides[previous_side_id].to.y = y
            _polygons[_polygon_id].sides[previous_side_id].update()
        }
    }

    fun close() {
        if (_polygons[_polygon_id].status == Polygon.REDIMENSIONNING_CLOSED) {
            _polygons[_polygon_id].close()
        }
    }
}