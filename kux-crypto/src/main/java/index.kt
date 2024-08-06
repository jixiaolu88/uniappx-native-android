@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uts.sdk.modules.kuxCrypto;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.util.encoders.Hex;
typealias OutputLength = Number;
open class SHA3Cfg (
    @JsonNotNull
    open var outputLength: OutputLength,
) : UTSObject()
open class Mode (
    @JsonNotNull
    open var ECB: Number,
    @JsonNotNull
    open var CBC: Number,
    @JsonNotNull
    open var CFB: Number,
    @JsonNotNull
    open var CTR: Number,
    @JsonNotNull
    open var OFB: Number,
) : UTSObject()
open class Pad (
    @JsonNotNull
    open var Pkcs7: Number,
    @JsonNotNull
    open var Iso97971: Number,
    @JsonNotNull
    open var AnsiX923: Number,
    @JsonNotNull
    open var Iso10126: Number,
    @JsonNotNull
    open var ZeroPadding: Number,
    @JsonNotNull
    open var NoPadding: Number,
) : UTSObject()
typealias OnCommonCallback = () -> Unit;
open class CipherOption (
    open var mode: Number? = null,
    open var padding: Number? = null,
    open var iv: String? = null,
    open var ivEncoding: String? = null,
) : UTSObject()
typealias OnErrorCallback = (error: Any) -> Unit;
interface IUtils {
    fun random(length: Number): String
    fun copyTextToClipboard(text: String)
    fun copyTextToClipboard(text: String, callback: OnCommonCallback?)
}
interface IAES {
    fun encrypt(message: String, secret: String): String
    fun encrypt(message: String, secret: String, cfg: CipherOption?): String
    fun decrypt(encryptedData: String, secret: String): String
    fun decrypt(encryptedData: String, secret: String, cfg: CipherOption?): String
}
interface ICrypto {
    fun MD5(message: String): String
    fun SHA1(message: String): String
    fun SHA256(message: String): String
    fun SHA512(message: String): String
    fun SHA3(message: String): String
    fun SHA3(message: String, cfg: SHA3Cfg?): String
    fun RIPEMD160(message: String): String
    val mode: Mode
    val pad: Pad
    val utils: IUtils
    var AES: IAES
    fun onError(callback: OnErrorCallback)
}
open class DemoActivity : Activity {
    constructor() : super() {}
    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState);
    }
}
fun isCustomEmulator(): Boolean {
    try {
        val packageManager = UTSAndroid.getUniActivity()!!.getPackageManager();
        var intent = Intent(UTSAndroid.getUniActivity(), DemoActivity().javaClass);
        var resolveInfo = packageManager.queryIntentActivities(intent, 0);
        if (resolveInfo.size == 0) {
            return false;
        }
        return true;
    }
     catch (err: Throwable) {
        return false;
    }
}
val bytesToHex = fun(bytes: ByteArray): String {
    val hexBuilder: StringBuilder = StringBuilder();
    for(b in bytes){
        val hex = Integer.toHexString((0xff and b).toInt());
        hexBuilder.append(String.format("%02x", b));
    }
    return hexBuilder.toString();
}
;
val hexToBytes = fun(hex: String): ByteArray {
    return hex.toByteArray(Charsets.UTF_8).map(fun(item): Byte {
        return item.toInt().toByte();
    }
    ).toByteArray();
}
;
val toByteArray = fun(message: String): ByteArray {
    return message.toByteArray(Charsets.UTF_8);
}
;
val copyText2Clipboard = fun(text: String){
    val context: Context = UTSAndroid.getAppContext()!!;
    val clipboard: ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;
    val clip: ClipData = ClipData.newPlainText("label", text);
    clipboard.setPrimaryClip(clip);
}
;
val ECB_MODE: Number = 0b001;
val CBC_MODE: Number = 0b010;
val CFB_MODE: Number = 0b100;
val CTR_MODE: Number = 0b101;
val OFB_MODE: Number = 0b110;
val PKCS7_PADDING: Number = 0x100;
val ISO_97971_PADDING: Number = 0x101;
val ANSI_X_923_PADDING: Number = 0x102;
val ISO_10126_PADDING: Number = 0x103;
val ZERO_PADDING: Number = 0x104;
val NO_PADDING: Number = 0x105;
val generateRandomString = fun(length: Number): String {
    var result = "";
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789/+=";
    run {
        var i: Number = 0;
        while(i < length){
            result += characters.charAt(Math.floor(Math.random() * characters.length));
            i++;
        }
    }
    return result;
}
;
fun initSecret(secret: String): String {
    var newSecret = secret;
    if (secret.length < 16) {
        newSecret = secret.padEnd(16, "x");
    } else if (secret.length > 16 && secret.length < 32) {
        newSecret = secret.padEnd(32, "x");
    } else if (secret.length > 32 && secret.length < 64) {
        newSecret = secret.padEnd(64, "x");
    } else if (secret.length > 64) {
        newSecret = secret.slice(0, 64);
    }
    return newSecret;
}
val getModeName = fun(mode: Number): String {
    when (mode) {
        CFB_MODE -> 
            {
                return "CFB";
                return "CBC";
            }
        CTR_MODE -> 
            {
                return "CTR";
                return "CBC";
            }
        OFB_MODE -> 
            {
                return "OFB";
                return "CBC";
            }
        ECB_MODE -> 
            {
                return "ECB";
                return "CBC";
            }
        else -> 
            return "CBC";
    }
}
;
val getPaddingName = fun(padding: Number): String {
    when (padding) {
        ISO_97971_PADDING -> 
            {
                return "ISO10126-2Padding";
                return "PKCS7Padding";
            }
        ISO_10126_PADDING -> 
            {
                return "ISO10126-2Padding";
                return "PKCS7Padding";
            }
        ZERO_PADDING -> 
            {
                return "ZeroPadding";
                return "PKCS7Padding";
            }
        NO_PADDING -> 
            {
                return "NoPadding";
                return "PKCS7Padding";
            }
        else -> 
            return "PKCS7Padding";
    }
}
;
open class AES : IAES {
    private var _ivSpec: IvParameterSpec? = null;
    private fun _getSecretKey(key: String): SecretKeySpec {
        val keyBytes: ByteArray = toByteArray(key);
        return SecretKeySpec(keyBytes, "AES");
    }
    private fun _checkSecret(secret: String): Boolean {
        if (secret.length != 16 && secret.length != 32 && secret.length != 64) {
            return false;
        }
        return true;
    }
    private fun _initIvSpec(iv: String?, cipher: Cipher?, ivBytes: ByteArray?): IvParameterSpec {
        var ivSpec: IvParameterSpec?;
        if (iv != null) {
            ivSpec = IvParameterSpec(ivBytes!!);
        } else {
            val ivBytes = ByteArray(cipher!!.getBlockSize());
            SecureRandom().nextBytes(ivBytes);
            ivSpec = IvParameterSpec(ivBytes);
        }
        if (this._ivSpec == null) {
            this._ivSpec = ivSpec;
        }
        return this._ivSpec!!;
    }
    private fun _getCipherInstance(cfg: CipherOption?): Cipher {
        val mode = cfg?.mode ?: CBC_MODE;
        val padding = cfg?.padding ?: PKCS7_PADDING;
        return Cipher.getInstance("AES/" + getModeName(mode) + "/" + getPaddingName(padding));
    }
    override fun encrypt(message: String, secret: String): String {
        return this.encrypt(message as String, secret as String, null);
    }
    override fun encrypt(message: String, secret: String, cfg: CipherOption?): String {
        try {
            this._ivSpec = null;
            val secretKeySpec: SecretKeySpec = this._getSecretKey(initSecret(secret));
            val cipher: Cipher = this._getCipherInstance(cfg);
            var ivBytes: ByteArray = ByteArray(cipher.getBlockSize());
            val mode = cfg?.mode ?: CBC_MODE;
            var iv = secret.padEnd(16, "x");
            if (cfg != null && cfg.iv != null && cfg!!.iv!!.length > 0) {
                iv = cfg.iv!!;
            }
            iv = initSecret(iv);
            val ivEncoding = cfg?.ivEncoding ?: null;
            if (iv.length != 0) {
                if (ivEncoding == "hex") {
                    ivBytes = hexToBytes(iv);
                } else if (ivEncoding == "base64") {
                    ivBytes = Base64.getDecoder().decode(iv);
                } else {
                    ivBytes = iv.toByteArray();
                }
            }
            if (mode == ECB_MODE) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            } else {
                val ivSpec = this._initIvSpec(iv ?: null, cipher, ivBytes);
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
            }
            val encryptedData: ByteArray = cipher.doFinal(toByteArray(message));
            if (iv.length == 0 && mode != ECB_MODE) {
                val encryptedDataWithIv = ByteArray(ivBytes.size + encryptedData.size);
                System.arraycopy(ivBytes, 0, encryptedDataWithIv, 0, ivBytes.size);
                System.arraycopy(encryptedData, 0, encryptedDataWithIv, ivBytes.size, encryptedData.size);
                return Base64.getEncoder().encodeToString(encryptedDataWithIv);
            }
            return Base64.getEncoder().encodeToString(encryptedData);
        }
         catch (err: Throwable) {
            console.error(err, " at uni_modules/kux-crypto/utssdk/app-android/AES.uts:101");
            return "";
        }
    }
    override fun decrypt(encryptedData: String, secret: String): String {
        return this.decrypt(encryptedData as String, secret as String, null);
    }
    override fun decrypt(encryptedData: String, secret: String, cfg: CipherOption?): String {
        try {
            val secretKey: SecretKey = this._getSecretKey(initSecret(secret));
            val cipher: Cipher = this._getCipherInstance(cfg);
            var ivBytes: ByteArray = ByteArray(cipher.getBlockSize());
            var encryptedDataBytes = Base64.getDecoder().decode(encryptedData);
            val mode = cfg?.mode ?: CBC_MODE;
            var iv = secret.padEnd(16, "x");
            if (cfg != null && cfg.iv != null && cfg!!.iv!!.length > 0) {
                iv = cfg.iv!!;
            }
            iv = initSecret(iv);
            val ivEncoding = cfg?.ivEncoding ?: null;
            if (iv!!.length == 0) {
                ivBytes = Arrays.copyOfRange(encryptedDataBytes, 0, 16);
                encryptedDataBytes = Arrays.copyOfRange(encryptedDataBytes, 16, encryptedDataBytes.size);
            } else {
                if (ivEncoding == "hex") {
                    ivBytes = hexToBytes(iv);
                } else if (ivEncoding == "base64") {
                    ivBytes = Base64.getDecoder().decode(iv);
                } else {
                    ivBytes = iv!!.toByteArray();
                }
            }
            if (mode == ECB_MODE) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            } else {
                val ivSpec = IvParameterSpec(ivBytes);
                cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            }
            val encrypted: ByteArray = cipher.doFinal(encryptedDataBytes);
            return String(encrypted, StandardCharsets.UTF_8);
        }
         catch (err: Throwable) {
            console.error(err, " at uni_modules/kux-crypto/utssdk/app-android/AES.uts:150");
            return "";
        }
    }
}
fun useAES(): IAES {
    return AES();
}
open class Utils : IUtils {
    override fun random(length: Number): String {
        return generateRandomString(length);
    }
    override fun copyTextToClipboard(text: String): Unit {
        this.copyTextToClipboard(text as String, null);
    }
    override fun copyTextToClipboard(text: String, callback: OnCommonCallback?) {
        copyText2Clipboard(text);
        callback?.invoke();
    }
}
val useUtils = fun(): IUtils {
    return Utils();
}
;
open class CryptoManager : ICrypto {
    override var AES: IAES = useAES();
    private var _needCustomEmulatorName = utsArrayOf(
        "SHA3-224",
        "SHA3-256",
        "SHA3-384",
        "SHA3-512",
        "RIPEMD160"
    );
    private var _onErrorCallback: OnErrorCallback? = null;
    private fun _needCustomEmulator(name: String): Boolean {
        return this._needCustomEmulatorName.indexOf(name) > -1;
    }
    private fun _SHA3(message: String = "", bit: OutputLength = 512): String {
        val sha3Digest = SHA3Digest(bit.toInt());
        sha3Digest.update(message.toByteArray(), 0, message.toByteArray().size);
        val result = ByteArray(sha3Digest.digestSize);
        sha3Digest.doFinal(result, 0);
        return Hex.toHexString(result);
    }
    private fun _RIPEMD160(message: String = ""): String {
        val ripemd160Digest = RIPEMD160Digest();
        ripemd160Digest.update(message.toByteArray(), 0, message.toByteArray().size);
        val result = ByteArray(ripemd160Digest.digestSize);
        ripemd160Digest.doFinal(result, 0);
        return Hex.toHexString(result);
    }
    private fun _messageDigestHash(message: String = "", name: String = "MD5"): String {
        try {
            if (this._needCustomEmulator(name)) {
                if (!isCustomEmulator()) {
                    console.error("\u4F7F\u7528\u3010" + name + "\u3011\u9700\u8981\u81EA\u5B9A\u4E49\u57FA\u5EA7\u73AF\u5883\uFF0C\u8BF7\u6253\u5305\u81EA\u5B9A\u4E49\u57FA\u5EA7\u8FD0\u884C", " at uni_modules/kux-crypto/utssdk/app-android/cryptoManager.uts:55");
                    return "";
                }
            }
            val md: MessageDigest = MessageDigest.getInstance(name);
            val hash = md.digest(message.toByteArray());
            return bytesToHex(hash);
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override val mode: Mode
        get(): Mode {
            return Mode(ECB = ECB_MODE, CBC = CBC_MODE, CFB = CFB_MODE, CTR = CTR_MODE, OFB = OFB_MODE);
        }
    override val pad: Pad
        get(): Pad {
            return Pad(Pkcs7 = PKCS7_PADDING, Iso97971 = ISO_97971_PADDING, AnsiX923 = ANSI_X_923_PADDING, Iso10126 = ISO_10126_PADDING, ZeroPadding = ZERO_PADDING, NoPadding = NO_PADDING);
        }
    override val utils: IUtils
        get(): IUtils {
            return useUtils();
        }
    override fun MD5(message: String): String {
        try {
            return this._messageDigestHash(message);
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override fun SHA1(message: String): String {
        try {
            return this._messageDigestHash(message, "SHA1");
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override fun SHA256(message: String): String {
        try {
            return this._messageDigestHash(message, "SHA256");
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override fun SHA512(message: String): String {
        try {
            return this._messageDigestHash(message, "SHA512");
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override fun SHA3(message: String): String {
        return this.SHA3(message as String, null);
    }
    override fun SHA3(message: String, cfg: SHA3Cfg?): String {
        try {
            val outputLength = cfg?.outputLength ?: 512;
            if (!isCustomEmulator()) {
                console.error("\u4F7F\u7528\u3010SHA3-" + outputLength + "\u3011\u9700\u8981\u81EA\u5B9A\u4E49\u57FA\u5EA7\u73AF\u5883\uFF0C\u8BF7\u6253\u5305\u81EA\u5B9A\u4E49\u57FA\u5EA7\u8FD0\u884C", " at uni_modules/kux-crypto/utssdk/app-android/cryptoManager.uts:139");
                return "";
            }
            return this._SHA3(message, outputLength);
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override fun RIPEMD160(message: String): String {
        try {
            if (!isCustomEmulator()) {
                console.error("\u4F7F\u7528\u3010RIPEMD160\u3011\u9700\u8981\u81EA\u5B9A\u4E49\u57FA\u5EA7\u73AF\u5883\uFF0C\u8BF7\u6253\u5305\u81EA\u5B9A\u4E49\u57FA\u5EA7\u8FD0\u884C", " at uni_modules/kux-crypto/utssdk/app-android/cryptoManager.uts:153");
                return "";
            }
            return this._RIPEMD160(message);
        }
         catch (err: Throwable) {
            this._onErrorCallback?.invoke(err);
            return "";
        }
    }
    override fun onError(callback: OnErrorCallback) {
        this._onErrorCallback = callback;
    }
}
val useCrypto = fun(): ICrypto {
    return CryptoManager();
}
;
