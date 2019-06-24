package com.kanshau.ladytaxi

        import android.content.res.Resources
        import androidx.appcompat.app.AppCompatActivity
        import android.os.Bundle

        import com.google.android.gms.maps.CameraUpdateFactory
        import com.google.android.gms.maps.GoogleMap
        import com.google.android.gms.maps.OnMapReadyCallback
        import com.google.android.gms.maps.SupportMapFragment
        import com.google.android.gms.maps.model.LatLng
        import com.google.android.gms.maps.model.MarkerOptions
        import com.kanshau.ladytaxi.fragments.orderCreate.OrderCreateFragment

        class MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                supportFragmentManager.beginTransaction()
                    .add(R.id.content, OrderCreateFragment())
                    .commit()
            }

            override fun getTheme(): Resources.Theme {
                val theme = super.getTheme()
                theme.applyStyle(R.style.AppTheme, true)
                return theme
            }
}
