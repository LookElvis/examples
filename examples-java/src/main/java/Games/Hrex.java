/**
 *
 */
package Games;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *@author: 刘翔
 *@create time: 2015年12月2日 下午9:47:40 
 *@description:
 **/
public class Hrex extends Application {

    public static Point[][] point = new Point[10][10];
    public int SCX = 40, SCY = 30 , Wid = 40, p1 = 0, p2 = 0, p3 = 0;
    public int NO1 = 0, NO2 = 0, NO3 = 0, isLeave = 0, random;

    public class Point extends Pane {

        public int isfull = 0;
        public Rectangle rec = new Rectangle(40, 40);

        public Point(){
            rec.setFill(Color.GRAY);
            rec.setStroke(Color.BLACK);
            this.getChildren().add(rec);
        }

        public Point(double CenterX, double CenterY){
            rec.setX(CenterX - Wid / 2);
            rec.setY(CenterY - Wid / 2);
            rec.setFill(Color.GRAY);
            rec.setStroke(Color.BLACK);
            this.getChildren().add(rec);
        }
    }

//	//整个面板
//	public class BlockAll extends BlockMove {
//		 Point a11 = new Point(SCX, SCY);
//		 Point a12 = new Point(SCX + Wid, SCY);
//		 Point a13 = new Point(SCX + 2 * Wid, SCY);
//		 Point a14 = new Point(SCX + 3 * Wid, SCY);
//		 Point a21 = new Point(SCX, SCY + Wid);
//		 Point a22 = new Point(SCX + Wid, SCY + Wid);
//		 Point a23 = new Point(SCX + 2 * Wid, SCY + Wid);
//		 Point a24 = new Point(SCX + 3 * Wid, SCY + Wid);
//		 Point a31 = new Point(SCX, SCY + 2 * Wid);
//		 Point a32 = new Point(SCX + Wid, SCY + 2 * Wid);
//		 Point a33 = new Point(SCX + 2 * Wid, SCY + 2 * Wid);
//		 Point a34 = new Point(SCX + 3 * Wid, SCY + 2 * Wid);
//		 Point a41 = new Point(SCX, SCY + 3 * Wid);
//		 Point a42 = new Point(SCX + Wid, SCY + 3 * Wid);
//		 Point a43 = new Point(SCX + 2 * Wid, SCY + 3 * Wid);
//		 Point a44 = new Point(SCX + 3 * Wid, SCY + 3 * Wid);	 
//	}

    //横线
    public class Block1 extends Pane {

        int PosX, PosY;
        Point a21 = new Point(SCX, SCY + Wid);
        Point a22 = new Point(SCX + Wid, SCY + Wid);
        Point a23 = new Point(SCX + 2 * Wid, SCY + Wid);
        Point a24 = new Point(SCX + 3 * Wid, SCY + Wid);

        public Block1(){
            a21.rec.setFill(Color.RED);
            a22.rec.setFill(Color.RED);
            a23.rec.setFill(Color.RED);
            a24.rec.setFill(Color.RED);
            this.getChildren().addAll(a21, a22, a23, a24);
            this.setOnMouseDragged(e -> {
                a21.setLayoutX(e.getX() - SCX);
                a21.setLayoutY(e.getY() - 2 * SCY);
                a22.setLayoutX(e.getX() - SCX);
                a22.setLayoutY(e.getY() - 2 * SCY);
                a23.setLayoutX(e.getX() - SCX);
                a23.setLayoutY(e.getY() - 2 * SCY);
                a24.setLayoutX(e.getX() - SCX);
                a24.setLayoutY(e.getY() - 2 * SCY);
            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 10 && PosY >= 0 && PosY < 7){
                    if(isFull(PosX, PosY) && isFull(PosX, PosY + 1) && isFull(PosX, PosY + 2)
                            && isFull(PosX, PosY + 3)){

                        for(int m = PosY; m <= PosY + 3; m++){
                            point[PosX][m].isfull = 1;
                            point[PosX][m].rec.setFill(Color.RED);
                        }

                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a21,a22,a23,a24);
                    }
                    else{
                        a21.setLayoutX(0);
                        a21.setLayoutY(0);
                        a22.setLayoutX(0);
                        a22.setLayoutY(0);
                        a23.setLayoutX(0);
                        a23.setLayoutY(0);
                        a24.setLayoutX(0);
                        a24.setLayoutY(0);
                    }

                }
                //若不符合放置要求 则重置该块
                else{
                    a21.setLayoutX(0);
                    a21.setLayoutY(0);
                    a22.setLayoutX(0);
                    a22.setLayoutY(0);
                    a23.setLayoutX(0);
                    a23.setLayoutY(0);
                    a24.setLayoutX(0);
                    a24.setLayoutY(0);
                }

            });
        }
    }

    //竖线
    public class Block2 extends Pane {

        int PosX, PosY;
        Point a12 = new Point(SCX + Wid, SCY);
        Point a22 = new Point(SCX + Wid, SCY + Wid);
        Point a32 = new Point(SCX + Wid, SCY + 2 * Wid);
        Point a42 = new Point(SCX + Wid, SCY + 3 * Wid);

        public Block2(){
            a12.rec.setFill(Color.YELLOW);
            a22.rec.setFill(Color.YELLOW);
            a32.rec.setFill(Color.YELLOW);
            a42.rec.setFill(Color.YELLOW);
            this.getChildren().addAll(a12, a22, a32, a42);
            this.setOnMouseDragged(e -> {
                a12.setLayoutX(e.getX() - 2 * SCX);
                a12.setLayoutY(e.getY() - SCY);
                a22.setLayoutX(e.getX() - 2 * SCX);
                a22.setLayoutY(e.getY() - SCY);
                a32.setLayoutX(e.getX() - 2 * SCX);
                a32.setLayoutY(e.getY() - SCY);
                a42.setLayoutX(e.getX() - 2 * SCX);
                a42.setLayoutY(e.getY() - SCY);
            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 7 && PosY >= 0 && PosY < 10){
                    if(isFull(PosX, PosY) && isFull(PosX + 1, PosY) && isFull(PosX + 2, PosY)
                            && isFull(PosX + 3, PosY)){

                        for(int m = PosX; m <= PosX + 3; m++){
                            point[m][PosY].isfull = 1;
                            point[m][PosY].rec.setFill(Color.YELLOW);
                        }

                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a12, a22, a32, a42);

                    }
                    else{
                        a12.setLayoutX(0);
                        a12.setLayoutY(0);
                        a22.setLayoutX(0);
                        a22.setLayoutY(0);
                        a32.setLayoutX(0);
                        a32.setLayoutY(0);
                        a42.setLayoutX(0);
                        a42.setLayoutY(0);
                    }

                }
                //若不符合放置要求 则重置该块
                else{
                    a12.setLayoutX(0);
                    a12.setLayoutY(0);
                    a22.setLayoutX(0);
                    a22.setLayoutY(0);
                    a32.setLayoutX(0);
                    a32.setLayoutY(0);
                    a42.setLayoutX(0);
                    a42.setLayoutY(0);
                }
            });
        }
    }

    //方块
    public class Block3 extends Pane {

        int PosX, PosY;
        Point a22 = new Point(SCX + Wid, SCY + Wid);
        Point a23 = new Point(SCX + 2 * Wid, SCY + Wid);
        Point a32 = new Point(SCX + Wid, SCY + 2 * Wid);
        Point a33 = new Point(SCX + 2 * Wid, SCY + 2 * Wid);

        public Block3(){
            a22.rec.setFill(Color.YELLOWGREEN);
            a23.rec.setFill(Color.YELLOWGREEN);
            a32.rec.setFill(Color.YELLOWGREEN);
            a33.rec.setFill(Color.YELLOWGREEN);
            this.getChildren().addAll(a22, a23, a32, a33);
            this.setOnMouseDragged(e -> {
                a22.setLayoutX(e.getX() - 2 * SCX);
                a22.setLayoutY(e.getY() - 2 * SCY);
                a23.setLayoutX(e.getX() - 2 * SCX);
                a23.setLayoutY(e.getY() - 2 * SCY);
                a32.setLayoutX(e.getX() - 2 * SCX);
                a32.setLayoutY(e.getY() - 2 * SCY);
                a33.setLayoutX(e.getX() - 2 * SCX);
                a33.setLayoutY(e.getY() - 2 * SCY);


            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 9 && PosY >= 0 && PosY < 9){
                    if(isFull(PosX, PosY) && isFull(PosX, PosY + 1) && isFull(PosX + 1, PosY)
                            && isFull(PosX + 1, PosY + 1)){

                        for(int m = PosX; m <= PosX + 1; m++){
                            for(int n = PosY; n <= PosY + 1; n++){
                                point[m][n].isfull = 1;
                                point[m][n].rec.setFill(Color.YELLOWGREEN);
                            }
                        }


                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a22, a23, a32, a33);
                    }
                    else{
                        a22.setLayoutX(0);
                        a22.setLayoutY(0);
                        a23.setLayoutX(0);
                        a23.setLayoutY(0);
                        a32.setLayoutX(0);
                        a32.setLayoutY(0);
                        a33.setLayoutX(0);
                        a33.setLayoutY(0);
                    }
                }
                //若不符合放置要求 则重置该块
                else{
                    a22.setLayoutX(0);
                    a22.setLayoutY(0);
                    a23.setLayoutX(0);
                    a23.setLayoutY(0);
                    a32.setLayoutX(0);
                    a32.setLayoutY(0);
                    a33.setLayoutX(0);
                    a33.setLayoutY(0);
                }
            });
        }
    }

    //左下右上斜
    public class Block4 extends Pane {

        int PosX, PosY;
        Point a14 = new Point(SCX + 3 * Wid, SCY);
        Point a23 = new Point(SCX + 2 * Wid, SCY + Wid);
        Point a32 = new Point(SCX + Wid, SCY + 2 * Wid);
        Point a41 = new Point(SCX, SCY + 3 * Wid);

        public Block4(){
            a14.rec.setFill(Color.CORAL);
            a23.rec.setFill(Color.CORAL);
            a32.rec.setFill(Color.CORAL);
            a41.rec.setFill(Color.CORAL);
            this.getChildren().addAll(a14, a23, a32, a41);
            this.setOnMouseDragged(e -> {
                a14.setLayoutX(e.getX() - 4 * SCX);
                a14.setLayoutY(e.getY() - SCY);
                a23.setLayoutX(e.getX() - 4 * SCX);
                a23.setLayoutY(e.getY() - SCY);
                a32.setLayoutX(e.getX() - 4 * SCX);
                a32.setLayoutY(e.getY() - SCY);
                a41.setLayoutX(e.getX() - 4 * SCX);
                a41.setLayoutY(e.getY() - SCY);
            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 7 && PosY >= 3 && PosY < 10){
                    if(isFull(PosX, PosY) && isFull(PosX + 1, PosY - 1) && isFull(PosX + 2, PosY - 2)
                            && isFull(PosX + 3, PosY - 3)){


                        for(int m = PosX, n = PosY; m <= PosX + 3; m++, n--){
                            point[m][n].isfull = 1;
                            point[m][n].rec.setFill(Color.CORAL);
                        }

                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a14, a23, a32, a41);
                    }
                    else{
                        a14.setLayoutX(0);
                        a14.setLayoutY(0);
                        a23.setLayoutX(0);
                        a23.setLayoutY(0);
                        a32.setLayoutX(0);
                        a32.setLayoutY(0);
                        a41.setLayoutX(0);
                        a41.setLayoutY(0);
                    }

                }
                //若不符合放置要求 则重置该块
                else{
                    a14.setLayoutX(0);
                    a14.setLayoutY(0);
                    a23.setLayoutX(0);
                    a23.setLayoutY(0);
                    a32.setLayoutX(0);
                    a32.setLayoutY(0);
                    a41.setLayoutX(0);
                    a41.setLayoutY(0);
                }
            });
        }
    }

    //左上右下斜
    public class Block5 extends Pane {

        int PosX, PosY;
        Point a11 = new Point(SCX, SCY);
        Point a22 = new Point(SCX + Wid, SCY + Wid);
        Point a33 = new Point(SCX + 2 * Wid, SCY + 2 * Wid);
        Point a44 = new Point(SCX + 3 * Wid, SCY + 3 * Wid);

        public Block5(){
            a11.rec.setFill(Color.CADETBLUE);
            a22.rec.setFill(Color.CADETBLUE);
            a33.rec.setFill(Color.CADETBLUE);
            a44.rec.setFill(Color.CADETBLUE);
            this.getChildren().addAll(a11, a22, a33, a44);
            this.setOnMouseDragged(e -> {
                a11.setLayoutX(e.getX() - SCX);
                a11.setLayoutY(e.getY() - SCY);
                a22.setLayoutX(e.getX() - SCX);
                a22.setLayoutY(e.getY() - SCY);
                a33.setLayoutX(e.getX() - SCX);
                a33.setLayoutY(e.getY() - SCY);
                a44.setLayoutX(e.getX() - SCX);
                a44.setLayoutY(e.getY() - SCY);
            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 7 && PosY >= 0 && PosY < 7){
                    if(isFull(PosX, PosY) && isFull(PosX + 1, PosY + 1) && isFull(PosX + 2, PosY + 2)
                            && isFull(PosX + 3, PosY + 3)){

                        for(int m = PosX, n = PosY; m <= PosX + 3; m++, n++){
                            point[m][n].isfull = 1;
                            point[m][n].rec.setFill(Color.CADETBLUE);
                        }

                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a11, a22, a33, a44);
                    }
                    else{
                        a11.setLayoutX(0);
                        a11.setLayoutY(0);
                        a22.setLayoutX(0);
                        a22.setLayoutY(0);
                        a33.setLayoutX(0);
                        a33.setLayoutY(0);
                        a44.setLayoutX(0);
                        a44.setLayoutY(0);
                    }

                }
                //若不符合放置要求 则重置该块
                else{
                    a11.setLayoutX(0);
                    a11.setLayoutY(0);
                    a22.setLayoutX(0);
                    a22.setLayoutY(0);
                    a33.setLayoutX(0);
                    a33.setLayoutY(0);
                    a44.setLayoutX(0);
                    a44.setLayoutY(0);
                }
            });
        }
    }

    //z型块
    public class Block6 extends Pane {

        int PosX, PosY;
        Point a22 = new Point(SCX + Wid, SCY + Wid);
        Point a23 = new Point(SCX + 2 * Wid, SCY + Wid);
        Point a33 = new Point(SCX + 2 * Wid, SCY + 2 * Wid);
        Point a34 = new Point(SCX + 3 * Wid, SCY + 2 * Wid);

        public Block6(){
            a22.rec.setFill(Color.DARKVIOLET);
            a23.rec.setFill(Color.DARKVIOLET);
            a33.rec.setFill(Color.DARKVIOLET);
            a34.rec.setFill(Color.DARKVIOLET);
            this.getChildren().addAll(a22, a23, a33, a34);
            this.setOnMouseDragged(e -> {
                a22.setLayoutX(e.getX() - 2 * SCX);
                a22.setLayoutY(e.getY() - 2 * SCY);
                a23.setLayoutX(e.getX() - 2 * SCX);
                a23.setLayoutY(e.getY() - 2 * SCY);
                a33.setLayoutX(e.getX() - 2 * SCX);
                a33.setLayoutY(e.getY() - 2 * SCY);
                a34.setLayoutX(e.getX() - 2 * SCX);
                a34.setLayoutY(e.getY() - 2 * SCY);
            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 9 && PosY >= 0 && PosY < 8){
                    if(isFull(PosX, PosY) && isFull(PosX, PosY + 1) && isFull(PosX + 1, PosY + 1)
                            && isFull(PosX + 1, PosY + 2)){

                        point[PosX][PosY].isfull = 1;
                        point[PosX][PosY].rec.setFill(Color.DARKVIOLET);
                        point[PosX][PosY + 1].isfull = 1;
                        point[PosX][PosY + 1].rec.setFill(Color.DARKVIOLET);
                        point[PosX + 1][PosY + 1].isfull = 1;
                        point[PosX + 1][PosY + 1].rec.setFill(Color.DARKVIOLET);
                        point[PosX + 1][PosY + 2].isfull = 1;
                        point[PosX + 1][PosY + 2].rec.setFill(Color.DARKVIOLET);

                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a22, a23, a33, a34);

                    }
                    else{
                        a22.setLayoutX(0);
                        a22.setLayoutY(0);
                        a23.setLayoutX(0);
                        a23.setLayoutY(0);
                        a33.setLayoutX(0);
                        a33.setLayoutY(0);
                        a34.setLayoutX(0);
                        a34.setLayoutY(0);
                    }

                }
                //若不符合放置要求 则重置该块
                else{
                    a22.setLayoutX(0);
                    a22.setLayoutY(0);
                    a23.setLayoutX(0);
                    a23.setLayoutY(0);
                    a33.setLayoutX(0);
                    a33.setLayoutY(0);
                    a34.setLayoutX(0);
                    a34.setLayoutY(0);
                }
            });
        }
    }

    //一个方块
    public class Block7 extends Pane {

        int PosX, PosY;
        Point a22 = new Point(SCX + Wid, SCY + Wid);

        public Block7(){
            a22.rec.setFill(Color.YELLOW);
            this.getChildren().addAll(a22);

            this.setOnMouseDragged(e -> {
                a22.setLayoutX(e.getX() - 2 * SCX);
                a22.setLayoutY(e.getY() - 2 * SCY);
            });

            this.setOnMouseReleased(e -> {
                //计算放置坐标
                PosX = CalculateX(e.getSceneY());
                PosY = CalculateY(e.getSceneX());

                if(PosX >= 0 && PosX < 10 && PosY >= 0 && PosY < 10){
                    if(isFull(PosX, PosY)){

                        point[PosX][PosY].isfull = 1;
                        point[PosX][PosY].rec.setFill(Color.YELLOW);

                        //判断是否需要消除行
                        FixX();
                        FixY();

                        isLeave = 1;

                        this.getChildren().removeAll(a22);

                    }
                    else{
                        a22.setLayoutX(0);
                        a22.setLayoutY(0);
                    }

                }
                //若不符合放置要求 则重置该块
                else{
                    a22.setLayoutX(0);
                    a22.setLayoutY(0);
                }
            });

        }
    }

    @Override
    public void start(Stage stage) {
        //创建面板
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                gridpane.add(point[i][j] = new Point(), j , i);
            }
        }
        gridpane.setAlignment(Pos.CENTER);

        //选择图形框
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(200, 540);
        vbox.setAlignment(Pos.CENTER);

        //面板1
        Pane pane1 = new Pane();
//		pane1.setStyle("-fx-border-color:blue");
        pane1.setPrefSize(200, 180);
        random = GetRandom();
        //随机产生三个图形
        if(random == 1){
            Block1 block1 = new Block1();
            pane1.getChildren().add(block1);
        }
        else if(random == 2){
            Block2 block2 = new Block2();
            pane1.getChildren().add(block2);
        }
        else if(random == 3){
            Block3 block3 = new Block3();
            pane1.getChildren().add(block3);
        }
        else if(random == 4){
            Block4 block4 = new Block4();
            pane1.getChildren().add(block4);
        }
        else if(random == 5){
            Block5 block5 = new Block5();
            pane1.getChildren().add(block5);
        }
        else if(random == 6){
            Block6 block6 = new Block6();
            pane1.getChildren().add(block6);
        }
        else if(random == 7){
            Block7 block7 = new Block7();
            pane1.getChildren().add(block7);
        }

        //面板2
        Pane pane2 = new Pane();
//		pane2.setStyle("-fx-border-color:green");
        pane2.setPrefSize(200, 180);
        random = GetRandom();
        //随机产生三个图形
        if(random == 1){
            Block1 block1 = new Block1();
            pane2.getChildren().add(block1);
        }
        else if(random == 2){
            Block2 block2 = new Block2();
            pane2.getChildren().add(block2);
        }
        else if(random == 3){
            Block3 block3 = new Block3();
            pane2.getChildren().add(block3);
        }
        else if(random == 4){
            Block4 block4 = new Block4();
            pane2.getChildren().add(block4);
        }
        else if(random == 5){
            Block5 block5 = new Block5();
            pane2.getChildren().add(block5);
        }
        else if(random == 6){
            Block6 block6 = new Block6();
            pane2.getChildren().add(block6);
        }
        else if(random == 7){
            Block7 block7 = new Block7();
            pane2.getChildren().add(block7);
        }


        //面板3
        Pane pane3 = new Pane();
//		pane3.setStyle("-fx-border-color:black");
        pane3.setPrefSize(200, 180);
        random = GetRandom();
        //随机产生三个图形
        if(random == 1){
            Block1 block1 = new Block1();
            pane3.getChildren().add(block1);
        }
        else if(random == 2){
            Block2 block2 = new Block2();
            pane3.getChildren().add(block2);
        }
        else if(random == 3){
            Block3 block3 = new Block3();
            pane3.getChildren().add(block3);
        }
        else if(random == 4){
            Block4 block4 = new Block4();
            pane3.getChildren().add(block4);
        }
        else if(random == 5){
            Block5 block5 = new Block5();
            pane3.getChildren().add(block5);
        }
        else if(random == 6){
            Block6 block6 = new Block6();
            pane3.getChildren().add(block6);
        }
        else if(random == 7){
            Block7 block7 = new Block7();
            pane3.getChildren().add(block7);
        }


        //将可选块添加进面板
        vbox.getChildren().addAll(pane1, pane2, pane3);

        pane1.setOnMouseReleased(e -> {
            random = GetRandom();
            if(isLeave == 1){
                //随机产生三个图形
                if(random == 1){
                    Block1 block1 = new Block1();
                    pane1.getChildren().add(block1);
                }
                else if(random == 2){
                    Block2 block2 = new Block2();
                    pane1.getChildren().add(block2);
                }
                else if(random == 3){
                    Block3 block3 = new Block3();
                    pane1.getChildren().add(block3);
                }
                else if(random == 4){
                    Block4 block4 = new Block4();
                    pane1.getChildren().add(block4);
                }
                else if(random == 5){
                    Block5 block5 = new Block5();
                    pane1.getChildren().add(block5);
                }
                else if(random == 6){
                    Block6 block6 = new Block6();
                    pane1.getChildren().add(block6);
                }
                else if(random == 7){
                    Block7 block7 = new Block7();
                    pane1.getChildren().add(block7);
                }

                isLeave = 0;
            }
        });

        pane2.setOnMouseReleased(e -> {
            random = GetRandom();
            if(isLeave == 1){
                //随机产生三个图形
                if(random == 1){
                    Block1 block1 = new Block1();
                    pane2.getChildren().add(block1);
                }
                else if(random == 2){
                    Block2 block2 = new Block2();
                    pane2.getChildren().add(block2);
                }
                else if(random == 3){
                    Block3 block3 = new Block3();
                    pane2.getChildren().add(block3);
                }
                else if(random == 4){
                    Block4 block4 = new Block4();
                    pane2.getChildren().add(block4);
                }
                else if(random == 5){
                    Block5 block5 = new Block5();
                    pane2.getChildren().add(block5);
                }
                else if(random == 6){
                    Block6 block6 = new Block6();
                    pane2.getChildren().add(block6);
                }
                else if(random == 7){
                    Block7 block7 = new Block7();
                    pane2.getChildren().add(block7);
                }

                isLeave = 0;
            }
        });

        pane3.setOnMouseReleased(e -> {
            random = GetRandom();
            if(isLeave == 1){
                //随机产生三个图形
                if(random == 1){
                    Block1 block1 = new Block1();
                    pane3.getChildren().add(block1);
                }
                else if(random == 2){
                    Block2 block2 = new Block2();
                    pane3.getChildren().add(block2);
                }
                else if(random == 3){
                    Block3 block3 = new Block3();
                    pane3.getChildren().add(block3);
                }
                else if(random == 4){
                    Block4 block4 = new Block4();
                    pane3.getChildren().add(block4);
                }
                else if(random == 5){
                    Block5 block5 = new Block5();
                    pane3.getChildren().add(block5);
                }
                else if(random == 6){
                    Block6 block6 = new Block6();
                    pane3.getChildren().add(block6);
                }
                else if(random == 7){
                    Block7 block7 = new Block7();
                    pane3.getChildren().add(block7);
                }

                isLeave = 0;
            }
        });


        //位置放置
        pane.setCenter(gridpane);
        pane.setRight(vbox);

        Scene scene = new Scene(pane,700,600);
        stage.setTitle("简易版拖动消除");
        stage.setScene(scene);
        stage.show();
    }

    //获得随机数
    static int GetRandom(){
        return ((int) (Math.random() * 7 + 1));
    }

    //判断是否为空
    static boolean isFull(int i, int j){
        if(point[i][j].isfull == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //判断是否消除行
    static void FixX(){
        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0;j < 10; j++){
                if(point[i][j].isfull == 1){
                    count ++;
                    if(count == 10){
                        for(int m = 0; m < 10; m++){
                            point[i][m].rec.setFill(Color.GRAY);
                            point[i][m].isfull = 0;
                        }
                    }
                }
            }
            count = 0;
        }
    }

    //判断是否消除列
    static void FixY(){
        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0;j < 10; j++){
                if(point[j][i].isfull == 1){
                    count ++;
                    if(count == 10){
                        for(int m = 0; m < 10; m++){
                            point[m][i].rec.setFill(Color.GRAY);
                            point[m][i].isfull = 0;
                        }
                    }
                }
            }
            count = 0;
        }
    }

    //通过坐标计算放置的行
    static int CalculateX(double SceneY){
        int x = (int) (SceneY - 100) / 40;
        return x;
    }

    //通过坐标计算放置的列
    static int CalculateY(double SceneX){
        int y = (int) (SceneX - 50) / 40;
        return y;

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}