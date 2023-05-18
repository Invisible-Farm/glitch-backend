package com.loeaf.file.service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 상속받아서 사용하세요!
 */
public abstract class AbsDataParserService implements FileParser {
    /**
     * classpath:/static/file/ fileName.csv 파일을 읽어와 행을 리턴합니다
     * Type ArrayList<List<String>>>
     * [[val, val, val],
     * [val, val, val],
     * [val, val, val]]
     * @param fileName
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public ArrayList<List<String>> readSampleData(String fileName) throws IOException, InvalidFormatException {
        //반환용 리스트
        ArrayList<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        File file = ResourceUtils.getFile("classpath:static/file/"+fileName);
        InputStream targetStream = new DataInputStream(new FileInputStream(file));
        try{
            br = new BufferedReader(new InputStreamReader(targetStream, "UTF-8"));
            //Charset.forName("UTF-8");
            String line = "";

            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
                ret.add(tmpList);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Type ArrayList<List<String>>>
     * [[val, val, val],
     * [val, val, val],
     * [val, val, val]]
     * 기반의 데이터가 어떠한 포멧형태로 파싱되어 클래스에 매핑되는지 구현하세요
     * @param parseDatas
     * @return
     */
    protected abstract List procSampleDataObj(ArrayList<List<String>> parseDatas);


    /**
     * 실행하기 위한 메서드
     * @param fullFilePath
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    @Override
    public List procParseFile(String fileName) throws IOException, InvalidFormatException {
        var p = readSampleData(fileName);
        var resultCol = procSampleDataObj(p);
        return resultCol;
    }
}
