import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadFile {
    public String readAsString(String path) throws IOException {
        File file = new File(path);
        return Files.asCharSource(file, UTF_8).read();
    }

    public static String readResourceAsString(String path) {
        InputStream stream = ReadFile.class.getResourceAsStream(path);
        try {
            return IOUtils.toString(stream,UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
