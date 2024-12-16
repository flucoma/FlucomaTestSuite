TestFluidTransientSlice : FluidUnitTest {
	test_impulse_stereo {
		FluidBufTransientSlice.process(
			server,
			impulsesBuffer,
			indices: resultBuffer
		).wait;

		result[\numSlices] = TestResult(resultBuffer.numFrames, 4);
		result[\numChannels] = TestResult(resultBuffer.numChannels, 1);

		//Check if the returned index position is correct (middle of file)
		if(resultBuffer.numFrames == 4, {
			resultBuffer.getn(0, 4, { | samples |
				result[\sampleIndex] = TestResultEquals(
					samples,
					((0..3) * (serverSampleRate / 4).asInteger) + 1000,
					8
				);
			});
		});
	}

	test_sharp_sine {
		FluidBufTransientSlice.process(
			server,
			sharpSineBuffer,
			indices: resultBuffer
		).wait;

		result[\numSlices] = TestResult(resultBuffer.numFrames, 4);

		//Check if the returned index position is correct (middle of file)
		if(resultBuffer.numFrames == 4, {
			resultBuffer.getn(0, 4, { | samples |
				result[\sampleIndex] = TestResultEquals(
					samples,
					[1000, 11025, 22050, 33075],
					8
				);
			});
		});
	}

	test_synth_basic {
		FluidBufTransientSlice.process(
			server,
			eurorackSynthBuffer,
			indices: resultBuffer
		).wait;

		result[\numSlices] = TestResult(resultBuffer.numFrames, 44);

		//Check if the returned index position is correct (middle of file)
		resultBuffer.getn(0, resultBuffer.numFrames, { | samples |
			result[\sampleIndex] = TestResultEquals(
				samples,
				[146, 19189, 34710, 47225, 49466, 58303, 68190, 86944, 105695, 106754, 117448, 122139, 139530, 150492, 152884, 161525, 167575, 186297, 223797, 250361, 256305, 280173, 306507, 310674, 312509, 319116, 327659, 335219, 346779, 364673, 384784, 413937, 429154, 431229, 434504, 439537, 441625, 452032, 453392, 465470, 481516, 494517, 496122, 514126],
				1
			);
		});
	}

	test_synth_advanced {
		FluidBufTransientSlice.process(
			server,
			eurorackSynthBuffer,
			indices: resultBuffer,numFrames: 220500, order: 200, blockSize: 2048, padSize: 1024, skew: 1, threshFwd: 3, threshBack: 1, windowSize: 15, clumpLength: 30, minSliceLength: 4410
		).wait;

		result[\numSlices] = TestResult(resultBuffer.numFrames, 17);

		//Check if the returned index position is correct (middle of file)
		resultBuffer.getn(0, resultBuffer.numFrames, { | samples |
			result[\sampleIndex] = TestResultEquals(
				samples,
				[667, 19184, 34706, 47229, 58300, 68183, 86942, 106752, 117438, 122135, 150487, 161523, 167572, 179048, 186294, 205050, 220493],
				1
			);
		});
	}

	test_AUDIO_SLICE_ARCHETYPE {
		var loadToFloatArrayCondition = Condition.new;
		var gateArray, indicesArray;

		{
			FluidTransientSlice.ar(PlayBuf.ar(1,eurorackSynthBuffer), order: 200, blockSize: 2048, padSize: 1024, skew: 1, threshFwd: 3, threshBack: 1, windowSize: 15, clumpLength: 30, minSliceLength: 4410);
		}.loadToFloatArray(4, server, { | array |
			gateArray = array;
			loadToFloatArrayCondition.unhang;
		});

		loadToFloatArrayCondition.hang;
		server.sync;

		indicesArray = gateArray.selectIndices{|i|i!=0};

		result[\numSlices] = TestResult(indicesArray.size, 13);
		result[\edgeValues] = TestResultEquals(gateArray[0,gateArray.size-1],[0,0],0);
		result[\changeIndices] = TestResultEquals(indicesArray, [667, 19184, 34706, 47229, 58300, 68183, 86942, 106752, 117438, 122135, 150487, 161523, 167572] + 2872, 1);//TODO: test at 48k
	}
}

