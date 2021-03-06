package koma.matrix.common

import koma.*
import koma.matrix.*
import koma.platformsupport.*

/**
 * Some functionality to help more easily implement double based koma backends. Feel free to not use if
 * your backend has fast implementations of these functions.
 */
abstract class DoubleFactoryBase<T: Matrix<Double>> : MatrixFactory<T> {
    override fun arange(start: Double, stop: Double, increment: Double): T {
        val len = round((stop - start) / increment).toInt()
        val out = this.zeros(1, len)
        for (i in 0 until len)
            out[i] = start + i * increment

        return out
    }

    override fun arange(start: Double, stop: Double): T {
        return arange(start, stop, 1.0 * signum(stop - start))
    }

    override fun arange(start: Int, stop: Int, increment: Int): T {
        return arange(start.toDouble(), stop.toDouble(), increment.toDouble())
    }

    override fun arange(start: Int, stop: Int): T {
        val inc = 1.0 * signum(stop.toDouble() - start.toDouble())
        return arange(start.toDouble(), stop.toDouble(), inc)
    }
}
