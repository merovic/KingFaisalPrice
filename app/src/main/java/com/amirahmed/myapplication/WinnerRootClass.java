package com.amirahmed.myapplication;

import org.json.*;

import com.google.gson.annotations.SerializedName;


public class WinnerRootClass{


	@SerializedName("date_prize")
	private String datePrize;
	@SerializedName("date_reg")
	private String dateReg;
	@SerializedName("id")
	private int id;
	@SerializedName("img")
	private String img;
	@SerializedName("name")
	private String name;
	@SerializedName("type")
	private String type;
	@SerializedName("url")
	private String url;
	@SerializedName("year")
	private String year;
	@SerializedName("video")
	private String video;
	@SerializedName("certif")
	private String certif;
	@SerializedName("file")
	private String file;

	public void setDatePrize(String datePrize){
		this.datePrize = datePrize;
	}
	public String getDatePrize(){
		return this.datePrize;
	}
	public void setDateReg(String dateReg){
		this.dateReg = dateReg;
	}
	public String getDateReg(){
		return this.dateReg;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setImg(String img){
		this.img = img;
	}
	public String getImg(){
		return this.img;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return this.url;
	}
	public void setYear(String year){
		this.year = year;
	}
	public String getYear(){
		return this.year;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getCertif() {
		return certif;
	}
	public void setCertif(String certif) {
		this.certif = certif;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public WinnerRootClass(String name, String type) {
		this.name = name;
		this.type = type;
	}
	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */



	public WinnerRootClass(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		datePrize = (String) jsonObject.opt("date_prize");
		dateReg = (String) jsonObject.opt("date_reg");
		img = (String) jsonObject.opt("img");
		name = (String) jsonObject.opt("name");
		type = (String) jsonObject.opt("type");
		url = (String) jsonObject.opt("url");
		year = (String) jsonObject.opt("year");
		id = jsonObject.optInt("id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("date_prize", datePrize);
			jsonObject.put("date_reg", dateReg);
			jsonObject.put("id", id);
			jsonObject.put("img", img);
			jsonObject.put("name", name);
			jsonObject.put("type", type);
			jsonObject.put("url", url);
			jsonObject.put("year", year);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}