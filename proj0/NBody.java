public class NBody{


public static double readRadius(String Fileload){
	
	In in=new In(Fileload);
	int n=in.readInt();
	double radius=in.readDouble();
	return radius;
}

public static Planet[] readPlanets(String Fileload){
    In in=new In(Fileload);
	int n=in.readInt();
	double radius=in.readDouble();
	Planet[] b =new Planet[n];
	for(int i=0;i<n;i=i+1){
	double xP=in.readDouble();
	double yP=in.readDouble();
	double xV=in.readDouble();
	double yV=in.readDouble();
	double m=in.readDouble();
	String img=in.readString();
	b[i]=new Planet(xP,yP,xV,yV,m,img);
	}
return b;
}
public static void main	(String[] args){
	double T=Double.parseDouble(args[0]);
	double dt=Double.parseDouble(args[1]);
	String filename =args[2];
	String imageToDraw ="images/starfield.jpg";
	double radius=NBody.readRadius(filename);
	int n;
	double t=0.0;
    Planet[] b=NBody.readPlanets(filename);
	StdDraw.enableDoubleBuffering();
	StdDraw.setScale(-radius,radius);
	StdDraw.clear();
	StdDraw.picture(0,0,imageToDraw);
	/* Shows the drawing to the screen, and waits 2000 milliseconds. */

	n=b.length;
	double[] xForces=new double[n];
	double[] yForces=new double[n];
	for(int i=0;i<n;i=i+1){
		b[i].draw();
	}

	while(t<T){
		for(int i=0;i<n;i=i+1){
		xForces[i]=b[i].calcNetForceExertedByX(b);
		yForces[i]=b[i].calcNetForceExertedByY(b);

	}
	for(int i=0;i<n;i=i+1){
			b[i].update(dt,xForces[i],yForces[i]);
	}
				StdDraw.picture(0,0,imageToDraw);
	for(int i=0;i<n;i=i+1){				
				b[i].draw();
	}
			    StdDraw.show();
			    StdDraw.pause(10);				

	t=t+dt;
	}
	StdOut.printf("%d\n",n);
    StdOut.printf("%.2e\n", radius);
       for (int i = 0; i < n; i++) {
                  StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  b[i].xxPos, b[i].yyPos, b[i].xxVel,
                  b[i].yyVel, b[i].mass, b[i].imgFileName);   
}
}
}