package com.homeworkreminder;

import java.util.ArrayList;
import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BluetoothActivity extends Activity implements OnItemClickListener{

	ListView listview;
	ArrayAdapter<String> adapter;
	
	BluetoothAdapter bAdapter;
	Set<BluetoothDevice> deviceSet;
	ArrayList<String> pairedDevices = new ArrayList<String>();
	
	IntentFilter filter;
	BroadcastReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bluetooth_activity_layout);
		
		listview = (ListView)findViewById(R.id.bluetooth_list);
		this.adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		listview.setAdapter(this.adapter);
		listview.setOnItemClickListener(this);
		
		bAdapter = BluetoothAdapter.getDefaultAdapter();
		if(bAdapter == null){
			Toast.makeText(getApplicationContext(), "No bluetooth detected", Toast.LENGTH_LONG).show();
			finish();
		}else{
			if(!bAdapter.isEnabled()){
				this.turnOnBluetooth();
			}
		}
		
		this.getPairedDevices();
		this.startDiscovery();
	}

	private void startDiscovery() {
		// TODO Auto-generated method stub
		bAdapter.cancelDiscovery();
		bAdapter.startDiscovery();
	}

	private void getPairedDevices() {
		// TODO Auto-generated method stub
		filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		receiver = new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				String action = intent.getAction();
				if(BluetoothDevice.ACTION_FOUND.equals(action)){
					BluetoothDevice newDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
					adapter.add(newDevice.getName());
					for(int a = 0; a < pairedDevices.size(); a++){
						if(newDevice.equals(pairedDevices.get(a))){
							adapter.add(newDevice.getName()+" Paired ");
						}else{
							adapter.add(newDevice.getName());
						}
					}
				}else if(BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)){
					
				}else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
					
				}else if(BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)){
					if(bAdapter.getState() == BluetoothAdapter.STATE_OFF){
						turnOnBluetooth();
					}
				}
			}
		};
		registerReceiver(receiver, filter);
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		registerReceiver(receiver, filter);
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		registerReceiver(receiver, filter);		
		filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_CANCELED){
			Toast.makeText(getApplicationContext(), "bluetooth not enabled", Toast.LENGTH_LONG).show();
			finish();
		}
		
		deviceSet = bAdapter.getBondedDevices();
		if(deviceSet.isEmpty()){
			Toast.makeText(getApplicationContext(), "No paired devices", Toast.LENGTH_LONG).show();
		}else{
			for(BluetoothDevice device:deviceSet){
				this.pairedDevices.add(device.getName());
			}
		}
	}
	
	private void turnOnBluetooth(){
		Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		startActivityForResult(intent, 1);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(receiver);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if(bAdapter.isDiscovering()){
			bAdapter.cancelDiscovery();
		}
		if(adapter.getItem(position).contains("Paired")){
			Toast.makeText(getApplicationContext(), "this device is paired", Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(getApplicationContext(), "this device is not paired", Toast.LENGTH_LONG).show();
		}
	}
	
}
