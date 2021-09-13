public class StateCensusData {
    public String state;
    public long population;
    public long areaInSqKm;
    public int DensityPerSqKm;

    public StateCensusData(String state, long population, long areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        DensityPerSqKm = densityPerSqKm;
    }

    public StateCensusData() {
    }
}
