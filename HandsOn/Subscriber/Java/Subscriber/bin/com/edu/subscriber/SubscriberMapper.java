package com.edu.Subscriber;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SubscriberMapper extends Mapper<LongWritable,Text,Text,DoubleWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)throws IOException,InterruptedException
	{
		
		String[] tokens = value.toString().split("=");
		Double bytes = Double.parseDouble(tokens[3].toString().trim()); 
		String custId = tokens[1].toString().substring(0,20).trim();
		context.write(new Text(custId), new DoubleWritable(bytes));
	}
}
