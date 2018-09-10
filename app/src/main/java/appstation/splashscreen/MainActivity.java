package appstation.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar superProgressBar;
    ImageView superImageView;
    WebView superWebView;
    LinearLayout superLinearLayout;
    EditText editText;
    Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superLinearLayout = (LinearLayout) findViewById(R.id.LinearLayout);
        superProgressBar = (ProgressBar) findViewById(R.id.myProgressBar);
        superImageView = (ImageView) findViewById(R.id.myImageView);
        superWebView = (WebView) findViewById(R.id.LX_Browser);
        editText = (EditText) findViewById(R.id.editText);
        button7 = (Button) findViewById(R.id.button7);

        superProgressBar.setMax(100);
        superWebView.loadUrl("https://www.google.com");
        superWebView.getSettings().setJavaScriptEnabled(true);
        superWebView.setWebViewClient(new WebViewClient());


        superWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                superProgressBar.setProgress(newProgress);
            }


            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                superImageView.setImageBitmap(icon);
            }
        });
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                superWebView.loadUrl("https://" + editText.getText().toString());
                editText.setText("");
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (superWebView.canGoBack()){
            superWebView.goBack();
        }
        else {
            finish();
        }
    }
}
