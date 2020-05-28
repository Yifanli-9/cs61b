public class Planet{
public double xxPos;
public double yyPos;
public double xxVel;
public double yyVel;
public double mass;
public String imgFileName;
double dis;
double dx;
double dy;
double forc;
double forcx;
double forcy;
static final double G=6.67e-11;
int leng;

public Planet(double xP, double yP, double xV, 
double yV, double m, String img){
	xxPos=xP;
	yyPos=yP;
	xxVel=xV;
	yyVel=yV;
	mass=m;
	imgFileName=img;
}
public double calcDistance(Planet b2){
	dx=this.xxPos-b2.xxPos;
	dy=this.yyPos-b2.yyPos;
	dis=Math.pow(dx,2)+Math.pow(dy,2);
	dis=Math.sqrt(dis);
	return dis;
	
}

public double calcForceExertedBy(Planet b2){
	dis=this.calcDistance(b2);
	forc=G*this.mass*b2.mass/Math.pow(dis,2);
	return forc;
	
	
	
}
public double calcForceExertedByX(Planet b2){
	forc=this.calcForceExertedBy(b2);
	dis=this.calcDistance(b2);
	dx=b2.xxPos-this.xxPos;
	forcx=forc*dx/dis;
	return forcx;
	
}
public double calcForceExertedByY(Planet b2){
	forc=this.calcForceExertedBy(b2);
	dis=this.calcDistance(b2);
	dy=b2.yyPos-this.yyPos;
	forcy=forc*dy/dis;
	return forcy;
	
	
}

public double calcNetForceExertedByX(Planet[] Planet){
	double netforce=0.0;
	leng=Planet.length;
	
	for(int i=0;i<Planet.length;i=i+1){
		if(this.equals(Planet[i])){
			continue;
		}
		else{
			netforce=netforce+this.calcForceExertedByX(Planet[i]);
		}

	}	
			return netforce;
}

public double calcNetForceExertedByY(Planet[] Planet){
	double netforce=0.0;
	leng=Planet.length;
	for(int i=0;i<Planet.length;i=i+1){
		if(this.equals(Planet[i])){
			continue;
		}
		else{
			netforce=netforce+this.calcForceExertedByY(Planet[i]);
		}

	}	
			return netforce;
}

public void update(double dt,double fX,double fY){
double ax;
double ay;

ax=fX/this.mass;
ay=fY/this.mass;
this.xxVel=this.xxVel+dt*ax;
this.yyVel=this.yyVel+dt*ay;
this.xxPos=this.xxPos+dt*this.xxVel;
this.yyPos=this.yyPos+dt*this.yyVel;

}
public void draw(){
	StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
}

public Planet(Planet b){
	xxPos=b.xxPos;
	yyPos=b.yyPos;
	xxVel=b.xxVel;
	yyVel=b.yyVel;
	mass=b.mass;
	imgFileName=b.imgFileName;
}
}