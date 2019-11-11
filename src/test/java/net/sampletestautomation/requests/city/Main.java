package net.sampletestautomation.requests.city;

public class Main{
	private double temp;
	private float tempMin;
	private int humidity;
	private int pressure;
	private float tempMax;

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	public void setTempMin(float tempMin){
		this.tempMin = tempMin;
	}

	public String getTempMin(){
		return String.valueOf(tempMin);
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	public void setTempMax(float tempMax){
		this.tempMax = tempMax;
	}

	public String getTempMax(){
		return String.valueOf(tempMax);
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}
}
