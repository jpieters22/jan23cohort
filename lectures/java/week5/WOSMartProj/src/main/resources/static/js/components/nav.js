console.log("can you see me I am different?")

class Nav extends HTMLElement {
    constructor() {
        super()
    }
    connectedCallback() {
        this.innerHTML = `
                <nav>
                    <a href="/">Home</a>
                </nav>

        `
    }
}
customElements.define('nav-component', Nav)