package debug
import android.app.Application
import com.billy.cc.core.component.BuildConfig
import com.billy.cc.core.component.CC

public class DebugApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        CC.enableDebug(BuildConfig.DEBUG);
        CC.enableVerboseLog(BuildConfig.DEBUG);
        CC.enableRemoteCC(BuildConfig.DEBUG);
    }

}