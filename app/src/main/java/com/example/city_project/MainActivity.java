package com.example.city_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.osmdroid.tileprovider.MapTile;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mMapView= (MapView) findViewById(R.id.mapView);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);

        String str1 = "http://mt0.google.cn/vt/lyrs=m&hl=zh-CN&gl=cn&scale=2";
        String str2 = "http://mt1.google.cn/vt/lyrs=m&hl=zh-CN&gl=cn&scale=2";
        String str3 = "http://mt2.google.cn/vt/lyrs=m&hl=zh-CN&gl=cn&scale=2";
        String str4 = "http://mt3.google.cn/vt/lyrs=m&hl=zh-CN&gl=cn&scale=2";
        GoogleMapsTileSource googleMapsTileSource = new GoogleMapsTileSource("GoogleNormal", 2, 19, 256, ".png", new String[]{str1, str2, str3, str4});
        mMapView.setTileSource(googleMapsTileSource);
        mMapView.setTilesScaledToDpi(true);

        CompassOverlay mCompassOverlay = new CompassOverlay(MainActivity.this, new InternalCompassOrientationProvider(MainActivity.this), mMapView);
        mMapView.getOverlays().add(mCompassOverlay);
        mCompassOverlay.enableCompass();

        ScaleBarOverlay mScaleBarOverlay = new ScaleBarOverlay(mMapView);
        mMapView.getOverlays().add(mScaleBarOverlay);
        mScaleBarOverlay.setAlignBottom(true);
        mScaleBarOverlay.setLineWidth(1 * (getResources().getDisplayMetrics()).density);
        mScaleBarOverlay.setMaxLength(0.85f);

        GeoPoint geopoint = new GeoPoint(34.0536909, -118.242766);
        MapController mMapController= (MapController) mMapView.getController();//获取MapView控制器
        mMapController.setCenter(geopoint);//设置地图中心

        mMapController.setZoom(15);
        mMapView.setBuiltInZoomControls(true);//设置缩放按钮可见
        mMapView.setMultiTouchControls(true);//设置多指触控可用

        RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(this, mMapView);
        mRotationGestureOverlay.setEnabled(true);
        mMapView.getOverlays().add(mRotationGestureOverlay);
    }

    public class GoogleMapsTileSource extends OnlineTileSourceBase {
        /**
         * @param aName                a human-friendly name for this tile source  自定图源义名字，会在手机外部存储中新建以该名字命名的文件夹，瓦片存储在其中
         * @param aZoomMinLevel        the minimum zoom level this tile source can provide  最小缩放级别
         * @param aZoomMaxLevel        the maximum zoom level this tile source can provide  最大缩放级别
         * @param aTileSizePixels      the tile size in pixels this tile source provides  瓦片质量 （256）
         * @param aImageFilenameEnding the file name extension used when constructing the filename  瓦片格式（jpg[有损压缩率高、不透明]、png[无损、透明]）
         * @param aBaseUrl             the base url(s) of the tile server used when constructing the url to download the tiles  下载瓦片的链接（前缀）
         */
        public GoogleMapsTileSource(String aName, int aZoomMinLevel, int aZoomMaxLevel, int aTileSizePixels, String aImageFilenameEnding, String[] aBaseUrl) {
            super(aName, aZoomMinLevel, aZoomMaxLevel, aTileSizePixels, aImageFilenameEnding, aBaseUrl);
        }

        @Override
        public String getTileURLString(MapTile aTile) {
            return getBaseUrl() + "&x=" + aTile.getX() + "&y=" + aTile.getY() + "&z=" + aTile.getZoomLevel();
        }
    }
}