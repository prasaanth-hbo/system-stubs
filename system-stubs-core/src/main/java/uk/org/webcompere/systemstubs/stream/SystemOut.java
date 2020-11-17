package uk.org.webcompere.systemstubs.stream;

import uk.org.webcompere.systemstubs.stream.output.Output;

import java.io.OutputStream;

/**
 * Replace System.out with an alternative
 * @since 1.0.0
 */
public class SystemOut extends SystemStreamBase {
    /**
     * Construct with the {@link OutputStream} to use in place of <code>System.out</code>
     * @param output new output target
     */
    public SystemOut(Output<? extends OutputStream> output) {
        super(output, System::setOut, () -> System.out);
    }

    /**
     * Default constructor, taps the output
     */
    public SystemOut() {
        super(System::setOut, () -> System.out);
    }
}
