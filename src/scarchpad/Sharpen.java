import java.awt.image.BufferedImage;

public class Sharpen {
    /*
//    compile group: 'com.mortennobel', name: 'java-image-scaling', version: '0.8.6'
    public BufferedImage scaleTo300ppi1(BufferedImage input) {
        int w;
        int h;

        w = multiple(input.getWidth());
        h = multiple(input.getHeight());

        ResampleOp resizeOp = new ResampleOp(w, h);
        resizeOp.setFilter(ResampleFilters.getLanczos3Filter());
        return resizeOp.filter(input, null);
    }*/
    /*

    private float[] normalizeKernel(float[] ar ) {

        float n = 0;
        for (int i = 0; i < ar.length; i++)
            n += ar[i];
        for (int i = 0; i < ar.length; i++)
            ar[i] /= n;

        return ar;
    }
    public BufferedImage sharpen(BufferedImage image, int i) {
        float[] matrix  =new float[] { -1, -1, -1, -1, i, -1, -1, -1, -1 };
        Kernel kernel = new Kernel(3, 3, normalizeKernel(matrix));

        Map<RenderingHints.Key, Object> map = new HashMap<RenderingHints.Key, Object>();
        map.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        map.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        map.put(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        BufferedImageOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,new RenderingHints(map));
        return op.filter(image, null);
    }

    //
//    @Test
//    @DisplayName("Image 4 - References are present in the converted test")
//    public void hasReferencesExample1() {
//        IntStream.range(2, 3).forEach(i ->
//            IntStream.range(1,15).forEach(s -> {
//            String result = classUnderTest.convert(getFile("./example" + i + ".png"), s);
//            System.out.println("========================================" + i);
//            System.out.println(result);
//        }));
//    }

//    @Test
//    public void hasTEST1111() {
//        String result = classUnderTest.convert(getFile("./example2_scale_428_sharpen100.png"));
//        System.out.println(result);
//    }

    @Test
    public void sharpen(int i) throws IOException {
        BufferedImage image = ImageIO.read(getFile("./input_image.png"));

        BufferedImage result = classUnderTest.sharpen(classUnderTest.scaleTo300ppi(image),  i);
        assertNotNull(result);
        File outputfile = new File("./expected_sharpen_image.png");
        ImageIO.write(result, "png", outputfile);
        fail("need some assert here");
    }
     */
}
