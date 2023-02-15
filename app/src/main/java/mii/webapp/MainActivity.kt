package mii.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import mii.webapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding untuk mengambil id dari view layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Menghide action bar di bagian atas
        supportActionBar?.hide()

        // Load Url website
        binding.WebView.webViewClient = WebViewClient()
        binding.WebView.loadUrl("https://web-app-react-js-net-hnge.vercel.app/?")

        // Activate Js & Bootstrap Function
        val webSettings = binding.WebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

    }

    override fun onBackPressed() {
        // Agar webview bisa back & tidak keluar dari activity
        if(binding.WebView.canGoBack()){
            binding.WebView.goBack()
        } else {
            super.onBackPressed()
        }

    }
}