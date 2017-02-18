package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.VisionCommand;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraSubsystem extends Subsystem {

	public String cam = "cam1";

	private int resX, resY;

	public UsbCamera gearCamera;
	public UsbCamera winchCamera;

	private CvSink cvSink;
	private CvSink cvSinc;
	private CvSource outputStream;

	private Mat source;
	private Mat output;

	private Scalar min;
	private Scalar max;

	public CameraSubsystem() {
		source = new Mat();
		output = new Mat();

		min = new Scalar(0, 200, 0);
		max = new Scalar(150, 230, 150);

		resX = 320;
		resY = 240;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new VisionCommand());
	}

	public void start() {
		new Thread(() -> {
			gearCamera = CameraServer.getInstance().startAutomaticCapture();
			gearCamera.setResolution(resX, resY);
			winchCamera.setResolution(resX, resY);
			
			cvSink = CameraServer.getInstance().getVideo();
			outputStream = CameraServer.getInstance().putVideo("Filter", resX, resY);

			while (!Thread.interrupted()) {
				cvSink.grabFrame(source);

				Imgproc.threshold(source, output, 100, 200, 0);
				Core.inRange(source, min, max, output);

				outputStream.putFrame(output);
			}
		}).start();
	}

	public void setCamera(UsbCamera camera) {
		camera = CameraServer.getInstance().startAutomaticCapture();
	}
}
