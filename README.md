Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.yeasin989:OurServers:1.0'
	}
	
	// import 
	import com.facebook.ads.Ads;
	
	
	
	Step 3. Android Get Mathod
	
	// Your Api Add here
         Ads.getAll(this, "asfhaskjfhkasdfhkajsfhkasjhf", new Ads.ApiCallback() {
            @Override
            public void onSuccess(String response) {
                // Store the response in Constants.SERVERS
                String servers = response;
                Toast.makeText(MainActivity.this,"Servers Response",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, "Expire Servers", Toast.LENGTH_SHORT).show();
            }
        });

	
	
	Thank you
