package fun

/**
 * Logging Aspect
 * @author SaumilP
 *
 */
trait LoggingProfiler {
    def methodProfiler(method: () => Unit) = {
        val start = System.nanoTime
        method()
        printf("Elapsed: %.3f seconds\n", 1e-9*(System.nanoTime-start))
    }
}