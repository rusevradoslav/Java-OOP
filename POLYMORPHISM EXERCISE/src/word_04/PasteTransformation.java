package word_04;

 class PasteTransformation implements TextTransform {
    private CutTransformation cutTransformation;

    public PasteTransformation(CutTransformation cutTransformation) {
        this.cutTransformation = cutTransformation;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, cutTransformation.getLastCut().toString());
    }
}
