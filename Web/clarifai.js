let app = new Clarifai.App({
    apiKey: keys.cfKey
});

function returnData() {

    let top5 = [];

    console.log("Made it")
    app.models.initModel({id: Clarifai.GENERAL_MODEL, version: "aa7f35c01e0642fda5cf400f543e7c40"})
        .then(generalModel => {
            return generalModel.predict(document.getElementById('photo1').getAttribute('src'));
        })
        .then(response => {
            var concepts = response['outputs'][0]['data']['concepts'];
            console.log(concepts);

            for (i = 0; i < 5; i++) {
                console.log(concepts[i].name);
                top5[i] = concepts[i].name;
            }

            // console.log(top5.toString());
            document.getElementById('photo1txt').innerText = top5.toString();



        })

}


