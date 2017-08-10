package org.androidtown.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.skp.Tmap.TMapView;

public class NewActivity4 extends AppCompatActivity {

    private static final String API_KEY = "a99f1b05-2f53-3cb8-b7a8-8d5436cdb44c";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new4);

        //선언
        FrameLayout frameLayout = new FrameLayout(this);
        TMapView tmapview = new TMapView(this);

        //키값
        tmapview.setSKPMapApiKey(API_KEY);

        //현재보는 방향
        tmapview.setCompassMode(true);

        //현위치 아이콘 표시
        tmapview.setIconVisibility(true);

        //줌레벨 7~19까지 가능
        tmapview.setZoomLevel(15);
        tmapview.setMapType(TMapView.MAPTYPE_STANDARD);
        tmapview.setLanguage(TMapView.LANGUAGE_KOREAN);

        //화면 중심을 단말의 현재 위치로 이동
        tmapview.setTrackingMode(true);
        tmapview.setSightVisible(true);
        frameLayout.addView(tmapview);
        setContentView(frameLayout);
    }

    void setSKPMapApiKey(String apiKey){
        FrameLayout framelayout = (FrameLayout) findViewById(R.id.map_view);
        TMapView tmapView = new TMapView(this);
        framelayout.addView(tmapView);
        tmapView.setSKPMapApiKey(API_KEY);
    }

    void setLanguage(int language){
        TMapView tmapView = new TMapView(this);
        tmapView.setLanguage(TMapView.LANGUAGE_KOREAN);
    }

    void setCenterPoint(double LocationLongitude, double LocationLatitude){
        TMapView tmapView = new TMapView(this);
        tmapView.setCenterPoint(126.985022, 37.566474);
    }

    void setLocationPoint (double LocationLongitude, double LocationLatitude){
        TMapView tmapView = new TMapView(this);
        tmapView.setLocationPoint(126.985022, 37.566474);
    }


/*
    public void showMarkerPoint(){
        //마커 찍는 것 빨간 포인트
        for(int i = 0; i < m_mapPoint.size(); i++ ){
            TMapPoint point = new TMapPoint(m_mapPoint.get(i).getLatitude(), m_mapPoint.get(i).getLongitude());
            TMapMarkerItem item1 = new TMapMarkerItem();
            Bitmap bitmap = null;
            bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.poi_dot);
            //poi dot-지도에 꼽을 빨간 핀 이미지

            item1.setTMapPoint(point);
            item1.setName(m_mapPoint.get(i).getName());
            item1.setVisible(item1.VISIBLE);

            item1.setIcon(bitmap);

            bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.poi_dot);

            //풍선뷰 안의 항목에 글을 지정
            item1.setCalloutTitle(m_mapPoint.get(i).getName());
            item1.setCalloutSubTitle("서울");
            item1.setAutoCalloutVisible(true);

            Bitmap bitmap_i = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.i_go);

            item1.setCalloutRightButtonImage(bitmap_i);

            String strID = String.format("pmaker%d", mMarkerID++);

            tmapview.addMarkerItem(strID, item1);
            mArrayMarkerID.add(strID);

        }

    }*/



}
