package dev.xesam.android.web.jsbridge;

import android.annotation.SuppressLint;
import android.webkit.WebView;

import dev.xesam.android.web.jsbridge.server.ServerProxy;

/**
 * Created by xesamguo@gmail.com on 16-4-7.
 */
public final class JsBridge {

    private WebView mWebView;

    private ServerProxy mServerProxy;

    public JsBridge(WebView webView) {
        this.mWebView = webView;
        this.mServerProxy = new ServerProxy();
        inject(mWebView);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    public void inject(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(mServerProxy, ServerProxy.JAVA_BRIDGE);
    }

    public void register(TransactHandler transactHandler) {
        mServerProxy.register(transactHandler);
    }
}