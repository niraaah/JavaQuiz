package PictureDataLoader;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class PictureReturn extends PictureDataLoader{
    protected class PictureContent{//사진의 이미지가 담긴 라벨과 정답을 소유하는 클래스
        String answer;
        public JLabel la;
        PictureContent(String ans,JLabel la){
            this.answer=ans;
            this.la=la;
        }
    }

    List<PictureContent> pictureContainer = new Vector<>();//라벨과 정답을 쌍으로 묶어서 저장하는 벡터

    public PictureReturn(){
        initContainer();
        shuffleContainer();
    }

    private void initContainer(){
        for(String path : pictureData.keySet()){
            pictureContainer.add(new PictureContent(pictureData.get(path),getImageLabel(path)));
        }
    }

    private void shuffleContainer(){//
        Collections.shuffle(pictureContainer);
    }

    protected PictureContent getContent(){//실질적 리턴함수
        PictureContent temp  = new PictureContent(pictureContainer.get(0).answer, pictureContainer.get(0).la);
        removeContent();
        return temp;
    }

    private void removeContent(){
        pictureContainer.remove(0);
    }
}