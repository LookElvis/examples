package DesignPatterns.observer.weather;

//考虑一个问题，每次Subject都会将所有的数据推送给所有的观察者，
// 观察者被迫收到很多不需要的数据，这是一种推的方式；
// 如果Subject中的状态属性增多，就需要更新每位观察者的调用
// Sub可以采用设置getter的方式让观察者去拉，当然这加大了
// 观察者的工作量，这是一种拉的方式。
// Java内置的观察者模式支持者两种方式
public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay = 
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
//		//保留对Subject的引用是方便注销Subject
//		weatherData.removeObserver(forecastDisplay);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
