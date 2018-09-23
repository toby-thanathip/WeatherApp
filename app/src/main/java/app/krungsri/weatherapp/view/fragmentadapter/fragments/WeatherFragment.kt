package app.krungsri.weatherapp.view.fragmentadapter.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.krungsri.weatherapp.viewmodel.WeatherViewModel
import app.weather.krungsi.weatherapp.R
import kotlinx.android.synthetic.main.fragment_weather.*


class WeatherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        weatherViewModel.weather.observe(this, Observer {
            val lat = it!!.coordinates.lat.toString()
            textest.text = lat
        })

        weatherViewModel.getCurrentWeather("Bangkok", "metric")
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    companion object {
        fun newInstance(): WeatherFragment {
            return WeatherFragment()
        }
    }



}