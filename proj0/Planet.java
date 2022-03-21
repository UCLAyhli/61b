public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.imgFileName = img;
        this.mass = m;
        this.xxPos = xP;
        this.xxVel = xV;
        this.yyPos = yP;
        this.yyVel = yV;
    }

    public Planet(Planet p) {
        this.imgFileName = p.imgFileName;
        this.mass = p.mass;
        this.xxPos = p.xxPos;
        this.xxVel = p.xxVel;
        this.yyPos = p.yyPos;
        this.yyVel = p.yyVel;
    }

    public double calcDistance(Planet p) {
        double y_dis = Math.abs(p.yyPos - this.yyPos);
        double x_dis = Math.abs(p.xxPos - this.xxPos);
        double distance = Math.sqrt(y_dis * y_dis + x_dis * x_dis);
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        double force = p.mass * this.mass * 6.67E-11 / Math.pow(distance, 2);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double distance = this.calcDistance(p);
        double x_dis = p.xxPos - this.xxPos;
        double force = this.calcForceExertedBy(p);
        double xforce = force * x_dis / distance;
        return xforce;
    }

    public double calcForceExertedByY(Planet p) {
        double distance = this.calcDistance(p);
        double y_dis = p.yyPos - this.yyPos;
        double force = this.calcForceExertedBy(p);
        double yforce = force * y_dis / distance;
        return yforce;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double forcel = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.imgFileName== p[i].imgFileName && this.yyPos==p[i].yyPos && this.xxPos == p[i].xxPos
            && this.mass==p[i].mass && this.yyVel==p[i].yyVel&&this.xxVel==p[i].xxVel){
                continue;
            }
            double xforce = this.calcForceExertedByX(p[i]);
            forcel += xforce;
        }
        return forcel;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double forcel = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.imgFileName== p[i].imgFileName && this.yyPos==p[i].yyPos && this.xxPos == p[i].xxPos
                    && this.mass==p[i].mass && this.yyVel==p[i].yyVel&&this.xxVel==p[i].xxVel){
                continue;
            }
            double yforce = this.calcForceExertedByY(p[i]);
            forcel += yforce;
        }
        return forcel;
    }
    public void update(double dt, double fX, double fY){
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        this.xxVel = ax*dt + this.xxVel;
        this.yyVel = ay*dt + this.yyVel;
        this.xxPos = this.xxVel*dt + this.xxPos;
        this.yyPos = this.yyVel*dt + this.yyPos;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos, "images/"+this.imgFileName);
    }
}
