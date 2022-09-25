package com.motorcycle.motorking.page;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.motorcycle.motorking.R;
import com.motorcycle.motorking.base.BaseActivity;
import com.motorcycle.motorking.fragment.HomeTabFragment;
import com.motorcycle.motorking.fragment.MeFragment;
import com.motorcycle.motorking.fragment.MerchantFragment;
import com.motorcycle.motorking.fragment.VehicleFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";
    private static final long MIN_BACK_DURATION = 1500L;

    private Fragment homeFragment;
    private Fragment vehicleFragment;
    private Fragment merchantFragment;
    private Fragment meFragment;

    private RadioButton mBtnHome;
    private RadioButton mBtnVehicle;
    private RadioButton mBtnMerchant;
    private RadioButton mBtnMe;

    private long lastBackTime;

    private final Typeface NORMAL = Typeface.defaultFromStyle(Typeface.NORMAL);
    private final Typeface BOLD = Typeface.defaultFromStyle(Typeface.BOLD);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    @Override
    protected int getContainerId() {
        return R.id.fl_container;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        initTabs();
    }

    private void initData() {
    }

    private void initTabs() {
        homeFragment = HomeTabFragment.newInstance();
        vehicleFragment = VehicleFragment.newInstance();
        merchantFragment = MerchantFragment.newInstance();
        meFragment = MeFragment.newInstance();

        ((RadioGroup) findViewById(R.id.rg_tab)).setOnCheckedChangeListener(this);
        mBtnHome = findViewById(R.id.rb_home);
        setBounds(R.drawable.selector_tab_home, mBtnHome);
        mBtnVehicle = findViewById(R.id.rb_vehicle);
        setBounds(R.drawable.selector_tab_vehicle, mBtnVehicle);
        mBtnMerchant = findViewById(R.id.rb_merchant);
        setBounds(R.drawable.selector_tab_merchant, mBtnMerchant);
        mBtnMe = findViewById(R.id.rb_me);
        setBounds(R.drawable.selector_tab_me, mBtnMe);

        mBtnHome.setChecked(true);
    }

    private void setBounds(int drawableId, RadioButton radioButton) {
        Drawable icon = getResources().getDrawable(drawableId);
        icon.setBounds(0, 0, 40, 40);
        radioButton.setCompoundDrawables(null, icon, null, null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Fragment destFragment = null;
        if (checkedId == R.id.rb_home) {
            destFragment = homeFragment;

            setBtnBoldTypeface(mBtnHome);
            setBtnNormalTypeface(mBtnVehicle);
            setBtnNormalTypeface(mBtnMerchant);
            setBtnNormalTypeface(mBtnMe);
        } else if (checkedId == R.id.rb_vehicle) {
            destFragment = vehicleFragment;

            setBtnBoldTypeface(mBtnVehicle);
            setBtnNormalTypeface(mBtnHome);
            setBtnNormalTypeface(mBtnMerchant);
            setBtnNormalTypeface(mBtnMe);
        } else if (checkedId == R.id.rb_merchant) {
            destFragment = merchantFragment;

            setBtnBoldTypeface(mBtnMerchant);
            setBtnNormalTypeface(mBtnHome);
            setBtnNormalTypeface(mBtnVehicle);
            setBtnNormalTypeface(mBtnMe);
        } else if (checkedId == R.id.rb_me) {
            destFragment = meFragment;

            setBtnBoldTypeface(mBtnMe);
            setBtnNormalTypeface(mBtnHome);
            setBtnNormalTypeface(mBtnVehicle);
            setBtnNormalTypeface(mBtnMerchant);
        }

        if (destFragment != null) {
            switchTab(mCurFragment, destFragment, destFragment.getClass().getSimpleName());
        }
    }

    private void setBtnNormalTypeface(RadioButton radioButton) {
        radioButton.setTypeface(NORMAL);
    }

    private void setBtnBoldTypeface(RadioButton radioButton) {
        radioButton.setTypeface(BOLD);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (lastBackTime == 0 || System.currentTimeMillis() - lastBackTime > MIN_BACK_DURATION) {
                lastBackTime = System.currentTimeMillis();
                Toast.makeText(this, "再按一次退出App", Toast.LENGTH_SHORT);
                return true;
            }

            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
