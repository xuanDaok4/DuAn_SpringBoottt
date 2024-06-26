<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<script src="./libs/angular.min.js"></script>
<script src="./libs/anguler-route.min.js"></script>
<link rel="stylesheet" href="index.css">

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    :root {
        --primary-color: #D96AA7;
        --secondary-color: #422C73;
        --complimentary-color: #88BFB5;
        --contrast-color: #F2E527;
        --light-color: #D2A9D9;
    }

    .container {
        background: #191919;
        min-height: 100vh;
        font-family: Montserrat, sans-serif;
    }

    nav a {
        font-size: 40px;
        color: #fff;
        text-decoration: none;
        padding: 20px;
        text-align: center;
    }

    nav {
        position: fixed;
        left: 0;
        z-index: 50;
        display: flex;
        justify-content: space-around;
        flex-direction: column;
        height: 100vh;
        background: var(--secondary-color);
    }

    section {
        position: absolute;
        top: 0;
        height: 100vh;
        width: 0;
        opacity: 0;
        transition: all ease-in .5s;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    section h1 {
        color: #fff;
        font-size: 50px;
        text-transform: uppercase;
        opacity: 0;
    }

    /* Styles applied on trigger */
    section:target {
        opacity: 1;
        position: absolute;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 10;
    }

    section:target h1 {
        opacity: 0;
        animation: 2s fadeIn forwards .5s;
    }

    #first {
        background:var(--primary-color);
    }
    #second {
        background: var(--complimentary-color);
    }

    #third {
        background: var(--contrast-color);
    }

    #fourth {
        background: var(--light-color);
    }

    @keyframes fadeIn {
        100% { opacity:1 }
    }
</style>
<body ng-app="myApp">
<nav>
    <a href="#first"><i class="far fa-user">Bán Hàng</i></a>
    <a href="#second"><i class="fas fa-briefcase"></i></a>
    <a href="#third"><i class="far fa-file"></i></a>
    <a href="#fourth"><i class="far fa-address-card"></i></a>
</nav>

<div class= 'container'>
    <div ng-view>
    <section id= 'first'>
        <h1>First</h1>
    </section>

    <section id= 'second'>
        <h1>Second</h1>
    </section>

    <section id= 'third'>
        <h1>Third</h1>
    </section>

    <section id= 'fourth'>
        <h1>Fourth</h1>
    </section>
    </div>
</div>
</body>
<script>

</script>
</html>