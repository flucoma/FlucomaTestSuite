TestFluidKNNClassifier : FluidUnitTest {
	classvar testpoints;
	classvar assignments_target;

	*initClass {
		testpoints = [ [ 0.4212196954753, -0.38868429389804 ], [ 0.28521359421749, 0.62687367230478 ], [ -0.7797835973559, 0.66829682382788 ], [ -0.49798647096901, -0.49573549426258 ], [ 0.22518974443506, -0.35280755550692 ], [ 0.460874100429, 0.33013875999066 ], [ 0.43930173522552, 0.84230291751875 ], [ 0.69153871738305, 0.57192527995316 ], [ -0.23631494657612, 0.39324385349268 ], [ 0.49989651904126, -0.66056935365269 ], [ -0.45074971017759, -0.27266103328325 ], [ -0.35465591378072, 0.53873309665744 ], [ 0.63941241047176, 0.34332265922106 ], [ 0.61588542215732, -0.61480296773678 ], [ 0.51647235112467, -0.6718719606371 ], [ 0.4714454256321, 0.5903753225057 ], [ -0.42782811568546, -0.24423305165273 ], [ -0.3816575186201, -0.3967284816577 ], [ -0.39407552012845, -0.67073852686056 ], [ 0.54478288040562, -0.73961120560949 ], [ -0.50189197917253, -0.23271817568674 ], [ 0.67148247028272, 0.75673253746191 ], [ 0.67925494840639, -0.76376603347399 ], [ 0.74036772289535, -0.36477670703152 ], [ -0.22308756288576, -0.4530031423936 ], [ -0.42523082854213, 0.70974689841203 ], [ 0.36060643181375, 0.84901920498415 ], [ -0.41892850938235, -0.43893442028253 ], [ -0.37071061127874, -0.61627721536199 ], [ -0.25830532140431, -0.75311758032617 ], [ -0.35838357010605, 0.67051797329903 ], [ 0.62215875692875, -0.10379407286702 ], [ 0.38506920203098, -0.49187505857923 ], [ -0.49293802290181, 0.52563639925522 ], [ -0.52024390813355, 0.43557406461991 ], [ 0.45542569440734, 0.61600796496087 ], [ 0.31709611740442, -0.4762597344697 ], [ -0.28923913119688, -0.43004994075352 ], [ -0.45494587034218, -0.16894707408634 ], [ -0.67082813600238, 0.32863796222148 ], [ 0.44785936282824, -0.27876044969499 ], [ 0.70939187490917, -0.68800430909507 ], [ 0.6552981572847, -0.56920916730273 ], [ -0.33946800573153, -0.70425989939179 ], [ 0.56814055179238, -0.63635616189788 ], [ 0.7660588057645, 0.83353786544167 ], [ 0.4384617020534, 0.54763708863616 ], [ 0.25005058116821, 0.56401006523616 ], [ 0.36428217901271, -0.57385225613258 ], [ 0.62007438257752, 0.13812241429064 ], [ -0.74622857311324, 0.20990082870944 ], [ -0.67527609909335, 0.77537234412926 ], [ -0.35733902548136, -0.39282259153431 ], [ 0.34406753210315, -0.28257072729363 ], [ -0.48101278191725, -0.57506455220931 ], [ 0.39948443046712, 0.32245199699391 ], [ 0.48711184101156, -0.58589134400659 ], [ -0.25761365172131, 0.51961651453177 ], [ -0.65981258840219, -0.23642887037728 ], [ -0.4730476382209, 0.58475640855 ], [ 0.36374161983236, 0.35315229286237 ], [ -0.60492739878253, -0.75198633764121 ], [ 0.61278039051892, -0.56746595488199 ], [ 0.59356463363726, 0.608445981106 ], [ 0.29337917195857, -0.69922532779813 ], [ -0.56425131977023, 0.60136129556946 ], [ -0.8456821893518, -0.55642389920257 ], [ 0.60822386556128, -0.48860651719746 ], [ -0.68553276183047, -0.69837860470312 ], [ -0.62813731297117, 0.7219131731296 ], [ 0.36609245185875, 0.27969014540475 ], [ -0.46305635150537, 0.49758438113956 ], [ 0.30531366710751, 0.34688382300964 ], [ 0.71294840917084, 0.41837239952091 ], [ 0.25039486388303, 0.48964824232066 ], [ -0.56261141166738, -0.7214407727143 ], [ -0.75939370138191, -0.4905681653522 ], [ -0.41421968012174, -0.48051231206041 ], [ 0.28655459767711, 0.40173505544406 ], [ -0.42552630079601, -0.63307217740278 ], [ 0.57644090665601, 0.60386687196397 ], [ 0.64993433739415, 0.64896141846041 ], [ -0.75794860291154, 0.51408288558718 ], [ -0.28016925079932, 0.39638059177532 ], [ -0.5943497571169, 0.36932396936526 ], [ -0.30867372575584, -0.760652039408 ], [ 0.60213754408822, 0.48834279334211 ], [ 0.43534423648251, 0.73156879194173 ], [ 0.51540620035952, 0.5395782534231 ], [ -0.39408822212661, 0.32660038651921 ], [ -0.28538086836671, -0.7140990828924 ], [ -0.4545586502418, 0.39228590906179 ], [ 0.66271541236964, -0.20697476816614 ], [ -0.4207226844729, 0.71307592973833 ], [ -0.63369216512744, 0.78166200808984 ], [ 0.27258318690078, 0.58415503889494 ], [ 0.52381984409515, -0.73226384046304 ], [ -0.2201598273588, 0.76188060817364 ], [ -0.38371787796502, -0.30710632103785 ], [ -0.57975365830848, -0.46714403245818 ], [ -0.87135026086994, -0.66265212263663 ], [ -0.73216931805137, 0.57233983274131 ], [ 0.66795962009595, -0.58043176226925 ], [ 0.33078890976107, -0.5949310160251 ], [ -0.33615247470206, -0.23710247131579 ], [ -0.22244515667451, -0.38102735185014 ], [ 0.19758939758966, -0.49935495085051 ], [ -0.32052798583512, 0.29461152166103 ], [ 0.44547805684066, 0.32891577970375 ], [ -0.87914886274706, -0.42365077731728 ], [ 0.19423745052812, 0.84465803355137 ], [ 0.47166452175142, -0.57079645335178 ], [ 0.40081288140585, 0.58045551192623 ], [ -0.36337379273957, 0.50010215134055 ], [ 0.6371529739415, 0.51871983482818 ], [ -0.56386208312364, 0.37843020099035 ], [ -0.39032256217467, 0.60854687578195 ], [ 0.28592720950805, 0.36751121438935 ], [ -0.62859756738789, 0.34003663714738 ], [ -0.27150992564298, 0.78862339893507 ], [ -0.56882593450473, 0.83045977549076 ], [ -0.37920910827985, 0.40294919165897 ], [ -0.58067740589378, 0.5122926178605 ], [ 0.27169958024978, -0.49633623240332 ], [ -0.39676702289027, 0.40231085990638 ], [ -0.61459773318984, -0.48960682353416 ], [ -0.50352922291671, -0.52729468646582 ], [ 0.50722812069941, 0.40806792027687 ] ];

		assignments_target = [ 'green', 'red', 'orange', 'blue', 'green', 'red', 'red', 'red', 'orange', 'green', 'blue', 'orange', 'red', 'green', 'green', 'red', 'blue', 'blue', 'blue', 'green', 'blue', 'red', 'green', 'green', 'blue', 'orange', 'red', 'blue', 'blue', 'blue', 'orange', 'green', 'green', 'orange', 'orange', 'red', 'green', 'blue', 'blue', 'orange', 'green', 'green', 'green', 'blue', 'green', 'red', 'red', 'red', 'green', 'red', 'orange', 'orange', 'blue', 'green', 'blue', 'red', 'green', 'orange', 'blue', 'orange', 'red', 'blue', 'green', 'red', 'green', 'orange', 'blue', 'green', 'blue', 'orange', 'red', 'orange', 'red', 'red', 'red', 'blue', 'blue', 'blue', 'red', 'blue', 'red', 'red', 'orange', 'orange', 'orange', 'blue', 'red', 'red', 'red', 'orange', 'blue', 'orange', 'green', 'orange', 'orange', 'red', 'green', 'orange', 'blue', 'blue', 'blue', 'orange', 'green', 'green', 'blue', 'blue', 'green', 'orange', 'red', 'blue', 'red', 'green', 'red', 'orange', 'red', 'orange', 'orange', 'red', 'orange', 'orange', 'orange', 'orange', 'orange', 'green', 'orange', 'blue', 'blue', 'red' ];
	}

	test_2d_points {
		var condition = Condition();
		var classifier = FluidKNNClassifier(server);
		var source = FluidDataSet(server);
		var labels = FluidLabelSet(server);
		var test = FluidDataSet(server);
		var mapping = FluidLabelSet(server);

		var examplepoints = [[0.5,0.5],[-0.5,0.5],[0.5,-0.5],[-0.5,-0.5]];
		var examplelabels = [\red,\orange,\green,\blue];
		var d = Dictionary.new;

		var assignments;

		var inbuf = Buffer.loadCollection(server,0.5.dup);
		var point_predict;

		d.add(\cols -> 2);
		d.add(\data -> Dictionary.newFrom(examplepoints.collect{|x, i|[i.asString, x]}.flatten));
		source.load(d);
		examplelabels.collect{|x,i| labels.addLabel(i, x);};

		d = Dictionary.with(
        *[\cols -> 2,\data -> Dictionary.newFrom(
            testpoints.collect{|x, i| [i, x]}.flatten)]);
		test.load(d);

		server.sync;

		classifier.fit(source, labels);
		classifier.predict(test, mapping, 1);

		assignments = Array.new(testpoints.size);

		testpoints.do{|x,i|
			mapping.getLabel(i, action:{|l|
				assignments = assignments.add(l);
			});
			server.sync;
		};

		result[\assignments_size] = TestResult(assignments.size, assignments_target.size);
		result[\assignments] = TestResult(assignments, assignments_target);

		classifier.predictPoint(inbuf,{|x| point_predict = x; condition.unhang});

		condition.hang;

		result[\point_predict] = TestResult(point_predict, \red);

		server.sync;
		classifier.free;
		source.free;
		labels.free;
		test.free;
		mapping.free;
	}
}

TestFluidKNNRegressor : FluidUnitTest {
	classvar outputdata_target;
	classvar sourcedata, targetdata, testdata;

	*initClass {
		sourcedata = 128.collect{|i|i/128};
		targetdata = 128.collect{|i| sin(2*pi*i/128) };
		testdata = 128.collect{|i|(i/128)**2};

		outputdata_target = [ 0.0, 0.00076175523469789, 0.0029945260541494, 0.0065485911011353, 0.011197914151324, 0.016668013427168, 0.022662962298064, 0.028883912501028, 0.035031451901688, 0.040778629252711, 0.045673915690025, 0.048796876372125, 0.05029642715941, 0.055581681057961, 0.085460305008679, 0.093959136039639, 0.098017140329561, 0.10245454791469, 0.13421703532478, 0.14432085400006, 0.14792345279924, 0.15801231992444, 0.19170204847162, 0.19640070825101, 0.22921374043038, 0.24185299243601, 0.24794539316195, 0.28439553068247, 0.29140258996055, 0.32649516414515, 0.33695096438195, 0.36981566500642, 0.38268343236509, 0.41492820880386, 0.42760638389858, 0.46156396153541, 0.47237727559227, 0.50870126424529, 0.51835643731496, 0.55452373132521, 0.58402884238568, 0.59666067300714, 0.63154053357992, 0.64288022691356, 0.67231554652135, 0.70518784131117, 0.73203405088268, 0.74365630965085, 0.77301045336274, 0.80047379626031, 0.82394901959844, 0.83468949216904, 0.85815798854772, 0.88169119660485, 0.90220167544057, 0.92020309709007, 0.93617301840216, 0.94400014572363, 0.95802231107119, 0.97036633336999, 0.98078835477783, 0.98909165611084, 0.99512299654953, 0.99877723536851, 1.0, 0.99877665657492, 0.99510529839637, 0.98896628876009, 0.98030366473301, 0.96902122840863, 0.95498417778754, 0.93801537635405, 0.90936110589322, 0.88533287580987, 0.85914060581188, 0.83151798050292, 0.80227159303371, 0.76846955467155, 0.71551813247828, 0.6742755978661, 0.63439328416365, 0.59182868450061, 0.52453170823185, 0.47334864754603, 0.42632783462247, 0.37181685185014, 0.2934083076474, 0.24157239816559, 0.16049707567772, 0.099093231975454, 0.043818541763643, -0.043043841816409, -0.09922946621712, -0.18435873244354, -0.24305052288218, -0.32381220287995, -0.38268343236509, -0.45904115420287, -0.51414372018484, -0.58664129304908, -0.63519876743519, -0.70251671903254, -0.7441269731443, -0.80236406402879, -0.8499308473224, -0.88234901180156, -0.92223600325245, -0.94482120693001, -0.97009644082292, -0.98850351649935, -0.99752291177478, -0.99957141111154, -0.9951847266722, -0.98117155595836, -0.95995514404426, -0.93886621884652, -0.90323764017077, -0.857762851039, -0.80491593583325, -0.74609641304965, -0.68148435603777, -0.62716575845501, -0.55096537088526, -0.46879164106274, -0.38144241232332, -0.28983257312212, -0.19498793988641, -0.09800945430995 ];
	}

	test_sine_chirp {
		var condition = Condition();
		var source = FluidDataSet(server);
		var target = FluidDataSet(server);
		var test = FluidDataSet(server);
		var output = FluidDataSet(server);
		var tmpbuf = Buffer.alloc(server,1);
		var regressor = FluidKNNRegressor(server);

		var outputdata;

		var inbuf = Buffer.loadCollection(server,[0.5]);
		var outbuf = Buffer.alloc(server, 1);
		var point_predict;

		source.load(
			Dictionary.with(
				*[\cols -> 1,\data -> Dictionary.newFrom(
					sourcedata.collect{|x, i| [i.asString, [x]]}.flatten)])
		);

		target.load(
			Dictionary.with(
				*[\cols -> 1,\data -> Dictionary.newFrom(
					targetdata.collect{|x, i| [i.asString, [x]]}.flatten)]);
		);

		test.load(
			Dictionary.with(
				*[\cols -> 1,\data -> Dictionary.newFrom(
					testdata.collect{|x, i| [i.asString, [x]]}.flatten)])
		);

		server.sync;

		outputdata = Array(128);
		regressor.fit(source, target);
		regressor.predict(test, output, 1, action:{
			output.dump{|x|
				var data = x["data"];
				128.do{|i|
					outputdata = outputdata.add(data[i.asString][0])
				};
				condition.unhang;
			};
		});

		condition.hang;

		result[\outputdata] = TestResultEquals(outputdata, outputdata_target, 0.0001);

		regressor.predictPoint(inbuf, outbuf, action:{outbuf.getn(0,1,{|x|point_predict = x; condition.unhang})});

		condition.hang;

		result[\point_predict] = TestResultEquals(point_predict, 1.2246468525852e-16, 0.0001);

		server.sync;
		source.free;
		target.free;
		test.free;
		output.free;
		regressor.free;
	}
}