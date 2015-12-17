package Model.graph;

import Exceptions.PositionsInvalidesException;
import Exceptions.RootNullException;
import Model.Batiments.Batiment;
import views.ViewConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jip on 22/11/2015.
 */

public class Graph implements ViewConstants{
    static final int DECLALAGE_COTE = 60;
    static final int PETIT_DECALAGE = 40;
    static final int GRAND_DECALAGE = 100;
    private Vertex root;
    private  Vertex[] vertices = new Vertex[54];
    private List<Edge> edges = new ArrayList<Edge>();

    public Graph(Vertex root)throws RootNullException{
        this.root = root;
        if(root == null)throw new RootNullException();
        initVerticesAndEdges();
    }

    public void initVerticesAndEdges()
    {
        vertices[0]= root;
        //On cr�e les noeuds et on les range dans une liste.
        for(int i = 1;i<54;i++) {
           vertices[i] = new Vertex();
        }
        initSetTopEdges(vertices);
        initSetLeftEdges(vertices);
        initSetRightEdges(vertices);
        initPositionVertices();
    }

    private void initSetRightEdges(Vertex[] toDo)
    {
        Edge edgeA;
        Edge edgeB;
        Vertex topA;
        Vertex topB;
        Vertex bottomA;
        Vertex bottomB;

        for(int i=0;i<3;i++)
        {
            topA = toDo[0+i];
            topB = toDo[47 + i];
            bottomA = toDo[4+i];
            bottomB = toDo[51 + i];

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setRight();
            edgeB.setRight();
        }
        for(int i=0;i<4;i++)
        {
            topA = toDo[7+i];
            topB = toDo[38 + i];
            bottomA = toDo[12+i];
            bottomB = toDo[43 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setRight();
            edgeB.setRight();
        }
        for(int i=0;i<5;i++)
        {
            topA = toDo[16+i];
            topB = toDo[27 + i];
            bottomA = toDo[22+i];
            bottomB = toDo[33 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setRight();
            edgeB.setRight();
        }


    }

    private void initSetLeftEdges(Vertex[] toDo)
    {
        Edge edgeA;
        Edge edgeB;
        Vertex topA;
        Vertex topB;
        Vertex bottomA;
        Vertex bottomB;

        for(int i=0;i<3;i++)
        {
            topA = toDo[0+i];
            topB = toDo[48 + i];
            bottomA = toDo[3+i];;
            bottomB = toDo[51 + i];

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<4;i++)
        {
            topA = toDo[7+i];
            topB = toDo[39 + i];
            bottomA = toDo[11+i];;
            bottomB = toDo[43 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<5;i++)
        {
            topA = toDo[16+i];
            topB = toDo[28 + i];
            bottomA = toDo[21+i];;
            bottomB = toDo[33 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
    }


    private void initSetTopEdges(Vertex[] toDo)
    {
        for(int i=0;i<4;i++)
        {
            Vertex topA = toDo[3+i];
            Vertex topB = toDo[43 + i];
            Vertex bottomA = toDo[7+i];;
            Vertex bottomB = toDo[47 + i];

            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setTop();
            edgeB.setTop();
        }
        for(int i=0;i<5;i++)
        {
            Vertex topA = toDo[11+i];
            Vertex topB = toDo[33 + i];
            Vertex bottomA = toDo[16+i];;
            Vertex bottomB = toDo[38 + i];
            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edges.add(edgeA);
            edges.add(edgeB);
            edgeA.setTop();
            edgeB.setTop();
        }
        for(int i=0;i<6;i++)
        {
            Vertex topA = toDo[21+i];
            Vertex bottomA = toDo[27+i];
            Edge edgeA = new Edge(topA,bottomA);
            edges.add(edgeA);
            edgeA.setTop();
        }
    }


    /*
        Initialise la position de l'intégralité des verties.
     */
    private void initPositionVertices()
    {
        for(int i=1;i<3;i++)
        {
            Vertex v = vertices[i];
            v.setX(root.getX()+2*DECLALAGE_COTE*i);
            v.setY(root.getY());
        }

        for(int i =0;i<3;i++){
            Vertex top = vertices[0 + i];
            Vertex[] tab = {vertices[3 + i],vertices[4 + i],vertices[7 + i],vertices[8 + i],vertices[12 + i]};
            setXYVertices(top,tab);
        }
        for(int i =0;i<4;i++){
            Vertex top = vertices[7 + i];
            Vertex[] tab = {vertices[11 + i],vertices[12 + i],vertices[16 + i],vertices[17 + i],vertices[22 + i]};
            setXYVertices(top,tab);
        }
        for(int i =0;i<5;i++){
            Vertex top = vertices[16 + i];
            Vertex[] tab = {vertices[21 + i],vertices[22 + i],vertices[27+ i],vertices[28 + i],vertices[33 + i]};
            setXYVertices(top, tab);
        }
        for(int i =0;i<4;i++){
            Vertex top = vertices[28 + i];
            Vertex[] tab = {vertices[33 + i],vertices[34 + i],vertices[38+ i],vertices[39 + i],vertices[43 + i]};
            setXYVertices(top, tab);
        }
        for(int i =0;i<3;i++){
            Vertex top = vertices[39 + i];
            Vertex[] tab = {vertices[43 + i],vertices[44 + i],vertices[47+ i],vertices[48 + i],vertices[51 + i]};
            setXYVertices(top, tab);
        }
    }
    /*
        Initialise la position des Vertex du tableau à partir de la position de top.
        Attention la position des vertex dans le tableau a une importance.
        Position:
            top
        0           1
        2           3
            4
     */
    private void setXYVertices(Vertex top,Vertex[] toDo) {
        int xO = top.getX();
        int yO = top.getY();
        for(int i=0;i<toDo.length;i++) {
            Vertex v = toDo[i];
            switch (i) {
                case 0:
                    v.setX(xO - DECLALAGE_COTE);
                    v.setY(yO + PETIT_DECALAGE);
                    break;
                case 1:
                    v.setX(xO + DECLALAGE_COTE);
                    v.setY(yO + PETIT_DECALAGE);
                    break;
                case 2:
                    v.setX(xO - DECLALAGE_COTE);
                    v.setY(yO + GRAND_DECALAGE);
                    break;
                case 3:
                    v.setX(xO + DECLALAGE_COTE);
                    v.setY(yO + GRAND_DECALAGE);
                    break;
                case 4:
                    v.setX(xO);
                    v.setY(yO +PETIT_DECALAGE + GRAND_DECALAGE);
                    break;
                default:
                    break;
            }
        }
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Vertex getVertexIndex(int index)
    {
        return vertices[index];
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addBatiment(Batiment batiment, Vertex vertex)
    {
        vertex.setBatiment(batiment);
    }

    public void addBatiment(Batiment batiment,int index)
    {
        vertices[index].setBatiment(batiment);
    }

    public Vertex converstionXY(int x,int y)throws PositionsInvalidesException {
        for(int i = 0; i < vertices.length; i++){

            int decalage = 20 ;
            Vertex v = vertices[i];
            if( x <= v.getX()+decalage && x >= v.getX()-decalage){
                if(y <= v.getY()+decalage && y>=v.getY()-decalage){
                    return v;
                    }
            }
        }
        throw new PositionsInvalidesException();
    }
    public Edge convertEdge(Vertex v1, Vertex v2){
        Edge tmp=new Edge(v1,v2);
            for (Edge e:getEdges()) {
                if ((e.vertexA==v1 && e.vertexB==v2)||(e.vertexA==v2 && e.vertexB==v1)){
                    return e;
                }
            }

        return null;
    }


}
