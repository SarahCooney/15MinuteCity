package com.mainCity.ui.fragment.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mainCity.R;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;

public class MapFragment extends Fragment {

    private MapViewModel mapViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mapViewModel =
                new ViewModelProvider(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);


        MapView mMapView= (MapView) root.findViewById(R.id.mapView);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setTilesScaledToDpi(true);

        CompassOverlay mCompassOverlay = new CompassOverlay(getContext(), new InternalCompassOrientationProvider(getContext()), mMapView);
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

        RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(getContext(), mMapView);
        mRotationGestureOverlay.setEnabled(true);
        mMapView.getOverlays().add(mRotationGestureOverlay);
        return root;
    }
}