
package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.VisionCommand;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraSubsystem extends Subsystem {
	private int resX, resY;

	private CvSink cvSink;
	private CvSource outputStream;
	private BufferedImage img;

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
	
//	public void TestRGB()
//	{
//		int x = 0;
//		int y = 0;
//		Color mycolor = new Color(img.getRGB(x, y));
//		int r = mycolor.getRed();
//		int g = mycolor.getGreen();
//		int b = mycolor.getBlue();
//		
//		for(int h = 0; h < resY; h++)
//		{
//			y=h;
//			for(int w = 0; w < resX; w++)
//			{
//				x=w;
//				if((r>200)&&(g>0)&&(b>180))
//				{
//					//meets min
//					if((r<256)&&(g<200)&&(b<256))
//					{
//						//meets max, is pinkgenta
//						
//					}
//				}
//			}
//		}
//	}

	public void initDefaultCommand() {
		setDefaultCommand(new VisionCommand());
	}

	public void start() {
		new Thread(() -> {			
			CameraServer.getInstance().startAutomaticCapture(1);
			CameraServer.getInstance().startAutomaticCapture(0);

			outputStream = CameraServer.getInstance().putVideo("Filter", resX, resY);

			while (!Thread.interrupted()) {
				cvSink = CameraServer.getInstance().getVideo();
				cvSink.grabFrame(source);

				Imgproc.threshold(source, output, 100, 200, 0);
				Imgproc.cornerHarris(source, output, 2, 3, .04);
				Core.inRange(source, min, max, output);

				outputStream.putFrame(output);
			}
		}).start();
	}

}

// Convert to java
//
//#include "opencv2/imgcodecs.hpp"
//#include "opencv2/highgui.hpp"
//#include "opencv2/imgproc.hpp"
//#include <iostream>
//
//using namespace cv;
//using namespace std;
//
///// Global variables
//Mat src, src_gray;
//int thresh = 200;
//int max_thresh = 255;
//
//const char* source_window = "Source image";
//const char* corners_window = "Corners detected";
//
///// Function header
//void cornerHarris_demo( int, void* );
//
///**
// * @function main
// */
//int main( int, char** argv )
//{
//  /// Load source image and convert it to gray
//  src = imread( argv[1], IMREAD_COLOR );
//  cvtColor( src, src_gray, COLOR_BGR2GRAY );
//
//  /// Create a window and a trackbar
//  namedWindow( source_window, WINDOW_AUTOSIZE );
//  createTrackbar( "Threshold: ", source_window, &thresh, max_thresh, cornerHarris_demo );
//  imshow( source_window, src );
//
//  cornerHarris_demo( 0, 0 );
//
//  waitKey(0);
//  return(0);
//}
//
///**
// * @function cornerHarris_demo
// * @brief Executes the corner detection and draw a circle around the possible corners
// */
//void cornerHarris_demo( int, void* )
//{
//
//  Mat dst, dst_norm, dst_norm_scaled;
//  dst = Mat::zeros( src.size(), CV_32FC1 );
//
//  /// Detector parameters
//  int blockSize = 2;
//  int apertureSize = 3;
//  double k = 0.04;
//
//  /// Detecting corners
//  cornerHarris( src_gray, dst, blockSize, apertureSize, k, BORDER_DEFAULT );
//
//  /// Normalizing
//  normalize( dst, dst_norm, 0, 255, NORM_MINMAX, CV_32FC1, Mat() );
//  convertScaleAbs( dst_norm, dst_norm_scaled );
//
//  /// marking corners
//  for( int j = 0; j < dst_norm.rows ; j++ )
//     { for( int i = 0; i < dst_norm.cols; i++ )
//          {
//            if( (int) dst_norm.at<float>(j,i) > thresh )
//              {
//               //make it a colour
//              }
//          }
//     }
//  /// Showing the result (it would be best if you converted this to a BufferedImage
//  namedWindow( corners_window, WINDOW_AUTOSIZE );
//  imshow( corners_window, dst_norm_scaled );
//}


