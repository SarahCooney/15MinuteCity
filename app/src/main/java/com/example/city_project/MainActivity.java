package com.example.city_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mMapView= (MapView) findViewById(R.id.mapView);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setTilesScaledToDpi(true);

        CompassOverlay mCompassOverlay = new CompassOverlay(MainActivity.this, new InternalCompassOrientationProvider(MainActivity.this), mMapView);
        mMapView.getOverlays().add(mCompassOverlay);
        mCompassOverlay.enableCompass();

        ScaleBarOverlay mScaleBarOverlay = new ScaleBarOverlay(mMapView);
        mMapView.getOverlays().add(mScaleBarOverlay);
        mScaleBarOverlay.setAlignBottom(true);
        mScaleBarOverlay.setLineWidth(1 * (getResources().getDisplayMetrics()).density);
        mScaleBarOverlay.setMaxLength(0.85f);

        GeoPoint geopoint = new GeoPoint(51496994, -134733);
        MapController mMapController= (MapController) mMapView.getController();
        mMapController.setCenter(geopoint);

        mMapController.setZoom(15);
        mMapView.setBuiltInZoomControls(true);
        mMapView.setMultiTouchControls(true);

        RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(this, mMapView);
        mRotationGestureOverlay.setEnabled(true);
        mMapView.getOverlays().add(mRotationGestureOverlay);
    }
}