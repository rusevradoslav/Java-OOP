package word_04;

 class CutTransformation implements TextTransform {
    private StringBuilder lastCut;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut = new StringBuilder();
        this.lastCut.append(text, startIndex, endIndex);
        text.delete(startIndex, endIndex);

    }

    public StringBuilder getLastCut() {
        return this.lastCut;
    }
}
