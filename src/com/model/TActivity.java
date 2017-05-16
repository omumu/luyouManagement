package com.model;

/**
 * 活动
 *
 */
public class TActivity  implements java.io.Serializable{

	private Integer id;
	
	private String kaishisj;
	
	private String jieshusj;
	
	private String zhuti;
	
	private String jieshao;
	
	private String jiangli;

	
	public TActivity() {
	}

	public TActivity(Integer id, String kaishisj, String jieshusj, String zhuti, String jieshao, String jiangli) {
		super();
		this.id = id;
		this.kaishisj = kaishisj;
		this.jieshusj = jieshusj;
		this.zhuti = zhuti;
		this.jieshao = jieshao;
		this.jiangli = jiangli;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKaishisj() {
		return kaishisj;
	}

	public void setKaishisj(String kaishisj) {
		this.kaishisj = kaishisj;
	}

	public String getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(String jieshusj) {
		this.jieshusj = jieshusj;
	}

	public String getZhuti() {
		return zhuti;
	}

	public void setZhuti(String zhuti) {
		this.zhuti = zhuti;
	}

	public String getJieshao() {
		return jieshao;
	}

	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}

	public String getJiangli() {
		return jiangli;
	}

	public void setJiangli(String jiangli) {
		this.jiangli = jiangli;
	}
	
	
}
