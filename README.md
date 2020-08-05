# star-ay

### aws configure

### 클러스터 생성
```
eksctl create cluster --name admin16-cluster --version 1.15 --nodegroup-name standard-workers --node-type t3.medium --nodes 3 --nodes-min 1 --nodes-max 3
```

### ecr생성
```
aws ecr create-repository --repository-name ecr-skcc-admin16-[서비스명] --image-scanning-configuration scanOnPush=true --region ap-southeast-1
```

### ecr로그인
```
aws ecr get-login-password --region ap-southeast-1 | docker login --username AWS --password-stdin 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com
```

### git 소스 upload, download 
###### 로컬에서 git으로 소스 upload
```
git add .
git commit -m "image change"
git push
```

cd /home/skccadmin/carrental-ay/gateway/
git clonehttps://github.com/l2skcc/gateway-ay.git
cd /home/skccadmin/carrental-ay/managment/
git clone https://github.com/l2skcc/management-ay.git
cd /home/skccadmin/carrental-ay/view/
git clone https://github.com/l2skcc/view-ay.git
cd /home/skccadmin/carrental-ay/rental/
git clone https://github.com/l2skcc/rental-ay.git
cd /home/skccadmin/carrental-ay/reservation/
git clone https://github.com/l2skcc/reservatoin-ay.git 
cd /home/skccadmin/carrental-ay/star/
git clone https://github.com/l2skcc/star-ay.git
cd /home/skccadmin/carrental-ay/payment/
git clone https://github.com/l2skcc/payment-ay.git

### gateway 빌드/배포/서비스노출
mvn package
docker build -t 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-gateway:v1 .
docker push 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-gateway:v1
kubectl create deploy gateway --image=052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-gateway:v1
kubectl expose deployment.apps/gateway --type=LoadBalancer --port=8080

### 서비스 빌드
cd /home/skccadmin/carrental-ay/managment/management-ay
mvn package
docker build -t 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-management:v1 .
docker push 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-management:v1

cd /home/skccadmin/carrental-ay/rental/rental-ay
mvn package
docker build -t 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-rental:v1 .
docker push 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-rental:v1

cd /home/skccadmin/carrental-ay/reservation/reservation-ay
mvn package
docker build -t 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-reservation:v1 .
docker push 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-reservation:v1

cd /home/skccadmin/carrental-ay/veiw/veiw-ay
mvn package
docker build -t 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-veiw:v1 .
docker push 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-veiw:v1

cd /home/skccadmin/carrental-ay/payment/payment-ay
mvn package
docker build -t 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-payment:v1 .
docker push 052937454741.dkr.ecr.ap-southeast-1.amazonaws.com/ecr-skcc-admin16-payment:v1


### 카프카 설치 
curl https://raw.githubusercontent.com/kubernetes/helm/master/scripts/get | bash
kubectl --namespace kube-system create sa tiller
kubectl create clusterrolebinding tiller --clusterrole cluster-admin --serviceaccount=kube-system:tiller
helm init --service-account tiller
kubectl patch deploy --namespace kube-system tiller-deploy -p '{"spec":{"template":{"spec":{"serviceAccount":"tiller"}}}}'
helm repo add incubator http://storage.googleapis.com/kubernetes-charts-incubator
helm repo update
helm install --name my-kafka --namespace kafka incubator/kafka

watch kubectl get all -n kafka

### 서비스 배포 
cd /home/skccadmin/carrental-ay/managment/management-ay/kubernetes
kubectl apply -f .
cd /home/skccadmin/carrental-ay/rental/rental-ay/kubernetes
kubectl apply -f .
cd /home/skccadmin/carrental-ay/reservation/reservatoin-ay/kubernetes
kubectl apply -f .
cd /home/skccadmin/carrental-ay/veiw/veiw-ay/kubernetes
kubectl apply -f .
cd /home/skccadmin/carrental-ay/payment/payment-ay/kubernetes
kubectl apply -f .
