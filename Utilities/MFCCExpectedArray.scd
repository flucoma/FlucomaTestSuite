(
s.waitForBoot({
	var numCoeffs = 13;
	var fftsize = 256;
	var hopsize = fftsize / 2;

	var b = Buffer.read(s, File.realpath(FluidBufMFCC.class.filenameSymbol).dirname.withTrailingSlash ++ "../AudioFiles/Nicol-LoopE-M.wav");
	var c = Buffer.new(s);

	s.sync;

	FluidBufMFCC.process(
		s,
		source: b,
		features: c,
		numCoeffs: numCoeffs,
		fftSize: fftsize,
		hopSize: hopsize,
		action: {
			var outArray;

			c.loadToFloatArray(action: { arg array; outArray = array });

			s.sync;

			File.use(File.realpath(TestFluidMFCC.class.filenameSymbol).dirname.withTrailingSlash ++ "MFCC.txt", "w", { | f |
				outArray.do({ | sample, index |
					var sampleOut;
					if(index < (outArray.size - 1), {
						sampleOut = sample.asString ++ ","
					}, {
						sampleOut = sample.asString
					});

					f.write(sampleOut);
				});
			});
		}
	);
});
)