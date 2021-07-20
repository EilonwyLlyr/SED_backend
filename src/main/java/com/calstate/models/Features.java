package com.calstate.models;

import java.util.Objects;

public class Features {
	private String kurtosisx;
	private String kurtosisy;
	private String kurtosisz;
	private String kurtosisf;
	private String abs_kurtosisx;
	private String abs_kurtosisy;
	private String abs_kurtosisz;
	private String abs_kurtosisf;
	private String minx;
	private String miny;
	private String minz;
	private String minf;
	private String abs_minx;
	private String abs_miny;
	private String abs_minz;
	private String abs_minf;
	private String maxx;
	private String maxy;
	private String maxz;
	private String maxf;
	private String abs_maxx;
	private String abs_maxy;
	private String abs_maxz;
	private String abs_maxf;
	private String meanx;
	private String meany;
	private String meanz;
	private String meanf;
	private String abs_meanx;
	private String abs_meany;
	private String abs_meanz;
	private String abs_meanf;
	private String medianx;
	private String mediany;
	private String medianz;
	private String medianf;
	public Features() {
		super();
	}
	public Features(String kurtosisx, String kurtosisy, String kurtosisz, String kurtosisf, String abs_kurtosisx,
			String abs_kurtosisy, String abs_kurtosisz, String abs_kurtosisf, String minx, String miny, String minz,
			String minf, String abs_minx, String abs_miny, String abs_minz, String abs_minf, String maxx, String maxy,
			String maxz, String maxf, String abs_maxx, String abs_maxy, String abs_maxz, String abs_maxf, String meanx,
			String meany, String meanz, String meanf, String abs_meanx, String abs_meany, String abs_meanz,
			String abs_meanf, String medianx, String mediany, String medianz, String medianf) {
		super();
		this.kurtosisx = kurtosisx;
		this.kurtosisy = kurtosisy;
		this.kurtosisz = kurtosisz;
		this.kurtosisf = kurtosisf;
		this.abs_kurtosisx = abs_kurtosisx;
		this.abs_kurtosisy = abs_kurtosisy;
		this.abs_kurtosisz = abs_kurtosisz;
		this.abs_kurtosisf = abs_kurtosisf;
		this.minx = minx;
		this.miny = miny;
		this.minz = minz;
		this.minf = minf;
		this.abs_minx = abs_minx;
		this.abs_miny = abs_miny;
		this.abs_minz = abs_minz;
		this.abs_minf = abs_minf;
		this.maxx = maxx;
		this.maxy = maxy;
		this.maxz = maxz;
		this.maxf = maxf;
		this.abs_maxx = abs_maxx;
		this.abs_maxy = abs_maxy;
		this.abs_maxz = abs_maxz;
		this.abs_maxf = abs_maxf;
		this.meanx = meanx;
		this.meany = meany;
		this.meanz = meanz;
		this.meanf = meanf;
		this.abs_meanx = abs_meanx;
		this.abs_meany = abs_meany;
		this.abs_meanz = abs_meanz;
		this.abs_meanf = abs_meanf;
		this.medianx = medianx;
		this.mediany = mediany;
		this.medianz = medianz;
		this.medianf = medianf;
	}
	public String getKurtosisx() {
		return kurtosisx;
	}
	public void setKurtosisx(String kurtosisx) {
		this.kurtosisx = kurtosisx;
	}
	public String getKurtosisy() {
		return kurtosisy;
	}
	public void setKurtosisy(String kurtosisy) {
		this.kurtosisy = kurtosisy;
	}
	public String getKurtosisz() {
		return kurtosisz;
	}
	public void setKurtosisz(String kurtosisz) {
		this.kurtosisz = kurtosisz;
	}
	public String getKurtosisf() {
		return kurtosisf;
	}
	public void setKurtosisf(String kurtosisf) {
		this.kurtosisf = kurtosisf;
	}
	public String getAbs_kurtosisx() {
		return abs_kurtosisx;
	}
	public void setAbs_kurtosisx(String abs_kurtosisx) {
		this.abs_kurtosisx = abs_kurtosisx;
	}
	public String getAbs_kurtosisy() {
		return abs_kurtosisy;
	}
	public void setAbs_kurtosisy(String abs_kurtosisy) {
		this.abs_kurtosisy = abs_kurtosisy;
	}
	public String getAbs_kurtosisz() {
		return abs_kurtosisz;
	}
	public void setAbs_kurtosisz(String abs_kurtosisz) {
		this.abs_kurtosisz = abs_kurtosisz;
	}
	public String getAbs_kurtosisf() {
		return abs_kurtosisf;
	}
	public void setAbs_kurtosisf(String abs_kurtosisf) {
		this.abs_kurtosisf = abs_kurtosisf;
	}
	public String getMinx() {
		return minx;
	}
	public void setMinx(String minx) {
		this.minx = minx;
	}
	public String getMiny() {
		return miny;
	}
	public void setMiny(String miny) {
		this.miny = miny;
	}
	public String getMinz() {
		return minz;
	}
	public void setMinz(String minz) {
		this.minz = minz;
	}
	public String getMinf() {
		return minf;
	}
	public void setMinf(String minf) {
		this.minf = minf;
	}
	public String getAbs_minx() {
		return abs_minx;
	}
	public void setAbs_minx(String abs_minx) {
		this.abs_minx = abs_minx;
	}
	public String getAbs_miny() {
		return abs_miny;
	}
	public void setAbs_miny(String abs_miny) {
		this.abs_miny = abs_miny;
	}
	public String getAbs_minz() {
		return abs_minz;
	}
	public void setAbs_minz(String abs_minz) {
		this.abs_minz = abs_minz;
	}
	public String getAbs_minf() {
		return abs_minf;
	}
	public void setAbs_minf(String abs_minf) {
		this.abs_minf = abs_minf;
	}
	public String getMaxx() {
		return maxx;
	}
	public void setMaxx(String maxx) {
		this.maxx = maxx;
	}
	public String getMaxy() {
		return maxy;
	}
	public void setMaxy(String maxy) {
		this.maxy = maxy;
	}
	public String getMaxz() {
		return maxz;
	}
	public void setMaxz(String maxz) {
		this.maxz = maxz;
	}
	public String getMaxf() {
		return maxf;
	}
	public void setMaxf(String maxf) {
		this.maxf = maxf;
	}
	public String getAbs_maxx() {
		return abs_maxx;
	}
	public void setAbs_maxx(String abs_maxx) {
		this.abs_maxx = abs_maxx;
	}
	public String getAbs_maxy() {
		return abs_maxy;
	}
	public void setAbs_maxy(String abs_maxy) {
		this.abs_maxy = abs_maxy;
	}
	public String getAbs_maxz() {
		return abs_maxz;
	}
	public void setAbs_maxz(String abs_maxz) {
		this.abs_maxz = abs_maxz;
	}
	public String getAbs_maxf() {
		return abs_maxf;
	}
	public void setAbs_maxf(String abs_maxf) {
		this.abs_maxf = abs_maxf;
	}
	public String getMeanx() {
		return meanx;
	}
	public void setMeanx(String meanx) {
		this.meanx = meanx;
	}
	public String getMeany() {
		return meany;
	}
	public void setMeany(String meany) {
		this.meany = meany;
	}
	public String getMeanz() {
		return meanz;
	}
	public void setMeanz(String meanz) {
		this.meanz = meanz;
	}
	public String getMeanf() {
		return meanf;
	}
	public void setMeanf(String meanf) {
		this.meanf = meanf;
	}
	public String getAbs_meanx() {
		return abs_meanx;
	}
	public void setAbs_meanx(String abs_meanx) {
		this.abs_meanx = abs_meanx;
	}
	public String getAbs_meany() {
		return abs_meany;
	}
	public void setAbs_meany(String abs_meany) {
		this.abs_meany = abs_meany;
	}
	public String getAbs_meanz() {
		return abs_meanz;
	}
	public void setAbs_meanz(String abs_meanz) {
		this.abs_meanz = abs_meanz;
	}
	public String getAbs_meanf() {
		return abs_meanf;
	}
	public void setAbs_meanf(String abs_meanf) {
		this.abs_meanf = abs_meanf;
	}
	public String getMedianx() {
		return medianx;
	}
	public void setMedianx(String medianx) {
		this.medianx = medianx;
	}
	public String getMediany() {
		return mediany;
	}
	public void setMediany(String mediany) {
		this.mediany = mediany;
	}
	public String getMedianz() {
		return medianz;
	}
	public void setMedianz(String medianz) {
		this.medianz = medianz;
	}
	public String getMedianf() {
		return medianf;
	}
	public void setMedianf(String medianf) {
		this.medianf = medianf;
	}
	@Override
	public int hashCode() {
		return Objects.hash(abs_kurtosisf, abs_kurtosisx, abs_kurtosisy, abs_kurtosisz, abs_maxf, abs_maxx, abs_maxy,
				abs_maxz, abs_meanf, abs_meanx, abs_meany, abs_meanz, abs_minf, abs_minx, abs_miny, abs_minz, kurtosisf,
				kurtosisx, kurtosisy, kurtosisz, maxf, maxx, maxy, maxz, meanf, meanx, meany, meanz, medianf, medianx,
				mediany, medianz, minf, minx, miny, minz);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Features)) {
			return false;
		}
		Features other = (Features) obj;
		return Objects.equals(abs_kurtosisf, other.abs_kurtosisf) && Objects.equals(abs_kurtosisx, other.abs_kurtosisx)
				&& Objects.equals(abs_kurtosisy, other.abs_kurtosisy)
				&& Objects.equals(abs_kurtosisz, other.abs_kurtosisz) && Objects.equals(abs_maxf, other.abs_maxf)
				&& Objects.equals(abs_maxx, other.abs_maxx) && Objects.equals(abs_maxy, other.abs_maxy)
				&& Objects.equals(abs_maxz, other.abs_maxz) && Objects.equals(abs_meanf, other.abs_meanf)
				&& Objects.equals(abs_meanx, other.abs_meanx) && Objects.equals(abs_meany, other.abs_meany)
				&& Objects.equals(abs_meanz, other.abs_meanz) && Objects.equals(abs_minf, other.abs_minf)
				&& Objects.equals(abs_minx, other.abs_minx) && Objects.equals(abs_miny, other.abs_miny)
				&& Objects.equals(abs_minz, other.abs_minz) && Objects.equals(kurtosisf, other.kurtosisf)
				&& Objects.equals(kurtosisx, other.kurtosisx) && Objects.equals(kurtosisy, other.kurtosisy)
				&& Objects.equals(kurtosisz, other.kurtosisz) && Objects.equals(maxf, other.maxf)
				&& Objects.equals(maxx, other.maxx) && Objects.equals(maxy, other.maxy)
				&& Objects.equals(maxz, other.maxz) && Objects.equals(meanf, other.meanf)
				&& Objects.equals(meanx, other.meanx) && Objects.equals(meany, other.meany)
				&& Objects.equals(meanz, other.meanz) && Objects.equals(medianf, other.medianf)
				&& Objects.equals(medianx, other.medianx) && Objects.equals(mediany, other.mediany)
				&& Objects.equals(medianz, other.medianz) && Objects.equals(minf, other.minf)
				&& Objects.equals(minx, other.minx) && Objects.equals(miny, other.miny)
				&& Objects.equals(minz, other.minz);
	}
	@Override
	public String toString() {
		return "{\"kurtosisx\":" + kurtosisx + ", \"kurtosisy\":" + kurtosisy + ", \"kurtosisz\":" + kurtosisz
				+ ", \"kurtosisf\":" + kurtosisf + ", \"abs_kurtosisx\":" + abs_kurtosisx + ", \"abs_kurtosisy\":" + abs_kurtosisy
				+ ", \"abs_kurtosisz\":" + abs_kurtosisz + ", \"abs_kurtosisf\":" + abs_kurtosisf + ", \"minx\":" + minx + ", \"miny\":"
				+ miny + ", \"minz\":" + minz + ", \"minf\":" + minf + ", \"abs_minx\":" + abs_minx + ", \"abs_miny\":" + abs_miny
				+ ", \"abs_minz\":" + abs_minz + ", \"abs_minf\":" + abs_minf + ", \"maxx\":" + maxx + ", \"maxy\":" + maxy + ", \"maxz\":"
				+ maxz + ", \"maxf\":" + maxf + ", \"abs_maxx\":" + abs_maxx + ", \"abs_maxy\":" + abs_maxy + ", \"abs_maxz\":"
				+ abs_maxz + ", \"abs_maxf\":" + abs_maxf + ", \"meanx\":" + meanx + ", \"meany\":" + meany + ", \"meanz\":" + meanz
				+ ", \"meanf\":" + meanf + ", \"abs_meanx\":" + abs_meanx + ", \"abs_meany\":" + abs_meany + ", \"abs_meanz\":"
				+ abs_meanz + ", \"abs_meanf\":" + abs_meanf + ", \"medianx\":" + medianx + ", \"mediany\":" + mediany
				+ ", \"medianz\":" + medianz + ", \"medianf\":" + medianf + "}";
	}
	
	
}
