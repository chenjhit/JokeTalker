package com.chenj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/11/26.
 */
public class GetRandomJoke {
    public static Double getAnDecimal(){
        return Math.random();
    }

    public static String getSomeJokes(){
        String[] commands = new String[]{"python","\\MyProject\\python\\JokeGetFunc.py"};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commands);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuffer sb = new StringBuffer();
            StringBuffer error = new StringBuffer();
            String line;
            while((line = bufferedReader.readLine())!=null){
                sb.append(line+"\n");
            }
            String json = sb.toString();
            /*while((line = br.readLine())!=null){
                error.append(line + "\n");
            }
            System.out.println(error.toString());*/
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Throwable e){
            e.printStackTrace();
        }finally{
            if(process != null){
                try{
                    process.waitFor();
                }catch(java.lang.InterruptedException e){
                    e.printStackTrace();
                }
                process.destroy();
            }
        }
        return "Fail";
    }

    public String findMe(){
        return "QQQ";
    }
}
